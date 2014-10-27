package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by brg on 25/10/2014.
 */

@Entity
public class Livro {

    public Livro() {
    }

    public Livro(int ISBN) {
        this.ISBN = ISBN;
    }

    @Id
    @Column(length = 13)
    private int ISBN;

    @Column
    private String nome;

    private String capa;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capaImg) {
        this.capa = capaImg;
    }
}
