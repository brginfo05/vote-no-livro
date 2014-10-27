package repositories;

import models.Usuario;
import play.db.jpa.JPA;

/**
 * Created by brg on 26/10/2014.
 */
public class Usuarios implements UsuarioRepository {

    @Override
    public Usuario recuperar(long id) {
        return JPA.em().find(Usuario.class, id);
    }

    @Override
    public Usuario novo() {
        Usuario usuario = new Usuario();
        usuario = JPA.em().merge(usuario);
        JPA.em().flush();
        return usuario;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario = JPA.em().merge(usuario);
        JPA.em().flush();
        return usuario;
    }
}
