package models;

import javax.persistence.*;

/**
 * Created by brg on 25/10/2014.
 */

@Entity
public class Voto {

    public Voto() {

    }

    public Voto(Livro visualizado, boolean votado, Livro par, Usuario usuario) {
        this.visualizado = visualizado;
        this.votado = votado;
        this.par = par;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Livro visualizado;
    private boolean votado;
    @ManyToOne
    private Livro par;
    @ManyToOne
    private Usuario usuario;


}
