package services;

import controllers.routes;
import models.Dupla;
import models.Livro;
import models.Usuario;
import repositories.LivroRepository;
import repositories.Livros;

/**
 * Created by brg on 30/10/2014.
 */
public class LivroService {

    //TODO IOC
    private LivroRepository livros = new Livros();

    public Dupla recuperarDupla(Usuario usuario) {
        Livro primeiroLivro = livros.recuperarPrimeiroLivro();
        Livro segundoLivro = livros.recuperarSegundoLivro(usuario, primeiroLivro);

        if (primeiroLivro == null || segundoLivro == null) {
            return null;
        }

        return new Dupla(primeiroLivro, segundoLivro);
    }
}
