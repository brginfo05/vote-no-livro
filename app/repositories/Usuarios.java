package repositories;

import models.Usuario;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;

/**
 * Created by brg on 26/10/2014.
 */
public class Usuarios implements UsuarioRepository {

    private EntityManager entityManager;

    public Usuarios(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Usuarios() {

    }

    @Override
    public Usuario recuperar(long id) {
        return getEntityManager().find(Usuario.class, id);
    }

    @Override
    public Usuario novo() {
        Usuario usuario = new Usuario();
        usuario = getEntityManager().merge(usuario);
        getEntityManager().flush();
        return usuario;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario = getEntityManager().merge(usuario);
        getEntityManager().flush();
        return usuario;
    }

    private EntityManager getEntityManager() {
        if(entityManager == null) {
            return JPA.em();
        }

        return entityManager;
    }
}
