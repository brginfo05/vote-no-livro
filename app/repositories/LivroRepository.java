package repositories;

import models.Livro;
import models.Usuario;

/**
 * Created by brg on 27/10/2014.
 */
public interface LivroRepository {
    Livro recuperarPrimeiroLivro();

    Livro recuperarSegundoLivro(Usuario usuario, Livro primeiroLivroRecuperado);
}
