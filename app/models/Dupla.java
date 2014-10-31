package models;

/**
 * Created by brg on 30/10/2014.
 */
public class Dupla {

    private Livro primeiroLivro;
    private Livro segundoLivro;

    public Dupla(Livro primeiroLivro, Livro segundoLivro) {
        this.primeiroLivro = primeiroLivro;
        this.segundoLivro = segundoLivro;
    }

    public Livro getPrimeiroLivro() {
        return primeiroLivro;
    }

    public Livro getSegundoLivro() {
        return segundoLivro;
    }
}
