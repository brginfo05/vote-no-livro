package models;

import org.apache.commons.lang3.StringUtils;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by brg on 25/10/2014.
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 254)
    private String email;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCadastrado() {
        return StringUtils.isNotBlank(name);
    }
}
