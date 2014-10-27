package repositories;

import models.Livro;
import models.Usuario;
import play.db.jpa.JPA;

import static utils.HibernateUtil.getFirstResult;

public class Livros implements LivroRepository {

    @Override
    public Livro recuperarPrimeiroLivro() {
        Livro livro = recuperarPrimeiroLivroSemVisualizacao();
        if (livro != null) {
            return livro;
        }

        return recuperarPrimeiroLivroComPoucaVisualizacao();
    }

    @Override
    public Livro recuperarSegundoLivro(Usuario usuario, Livro primeiroLivroRecuperado) {
        Livro livro = recuperarSegundoLivroSemVisualizacao(primeiroLivroRecuperado);
        if (livro != null) {
            return livro;
        }

        return recuperarLivroComPoucaVisualizacao(usuario, primeiroLivroRecuperado);
    }

    private Livro recuperarPrimeiroLivroSemVisualizacao() {
        String query = "select l from Livro l" +
                " where " +
                " not exists" +
                " (" +
                "   select 1 from Voto v where v.visualizado = l" +
                " )";

        return getFirstResult(JPA.em().createQuery(query, Livro.class));
    }

    private Livro recuperarPrimeiroLivroComPoucaVisualizacao() {
        String query = "select l from Voto v, Livro l" +
                " where" +
                " v.visualizado = l" +
                " group by l" +
                " order by count(l) asc";

        return getFirstResult(JPA.em().createQuery(query, Livro.class));
    }

    private Livro recuperarSegundoLivroSemVisualizacao(Livro primeiroLivroRecuperado) {
        String query = "select l from Livro l" +
                " where " +
                " not exists" +
                " (" +
                "   select 1 from Voto v where " +
                "   v.visualizado = l " +
                " )" +
                " and l <> :livro";

        return getFirstResult(JPA.em().createQuery(query, Livro.class)
                .setParameter("livro", primeiroLivroRecuperado));
    }

    private Livro recuperarLivroComPoucaVisualizacao(Usuario usuario, Livro primeiroLivroRecuperado) {
        String query = "select l from Voto v, Livro l" +
                " where" +
                " v.visualizado = l" +
                " and not exists" +
                " (" +
                "   select 1 from Voto v2 where " +
                "   v2.visualizado = l and v2.par = :livro and v2.usuario = :usuario " +
                " )" +
                " and l <> :livro" +
                " group by l" +
                " order by count(l) asc";

        return getFirstResult(JPA.em().createQuery(query, Livro.class)
                .setParameter("livro", primeiroLivroRecuperado)
        .setParameter("usuario", usuario));
    }
}
