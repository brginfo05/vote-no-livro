package repositories;

import models.Usuario;
import models.VotoConsolidado;
import play.db.jpa.JPA;

import java.util.List;

/**
 * Created by brg on 26/10/2014.
 */
public class VotosConsolidados implements VotoConsolidadoRepository {

    @Override
    public List<VotoConsolidado> recuperar() {
        String query = "select new models.VotoConsolidado(l, count(l)) " +
                "from Voto v, Livro l" +
                " where v.votado = :votado" +
                " and v.visualizado = l" +
                " group by l" +
                " order by count(l) desc";

        return JPA.em().createQuery(query, VotoConsolidado.class)
                .setParameter("votado", true)
                .getResultList();
    }

    @Override
    public List<VotoConsolidado> recuperar(Usuario usuario) {
        String query = "select new models.VotoConsolidado(l, count(l)) " +
                "from Voto v, Livro l" +
                " where v.votado = :votado" +
                " and v.visualizado = l" +
                " and v.usuario = :usuario" +
                " group by l" +
                " order by count(l) desc";

        return JPA.em().createQuery(query, VotoConsolidado.class)
                .setParameter("votado", true)
                .setParameter("usuario", usuario)
                .getResultList();
    }
}
