package models;

/**
 * Created by brg on 26/10/2014.
 */
public class VotoConsolidado {
    private Livro livro;
    private long votos;

    public VotoConsolidado(Livro livro, long votos) {
        this.livro = livro;
        this.votos = votos;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public long getVotos() {
        return votos;
    }

    public void setVotos(long votos) {
        this.votos = votos;
    }
}
