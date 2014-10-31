package controllers;

import models.Usuario;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;
import repositories.UsuarioRepository;
import repositories.Usuarios;

import static play.mvc.Controller.session;
import static play.mvc.Results.redirect;

/**
 * Created by brg on 26/10/2014.
 */
public class UsuarioController {

    private static final String USUARIO_KEY = "usuario";
    private static Form<Usuario> usuarioForm = Form.form(Usuario.class);
    private static UsuarioRepository usuarios = new Usuarios();

    @Transactional
    public static Result cadastrar() {
        Usuario usuario = usuarioForm.bindFromRequest().get();
        usuario.setId(getIdFromSession());

        usuarios.salvar(usuario);

        return redirect(routes.RankingController.exibir());
    }

    public static Usuario criar() {
        Usuario usuario;
        if (session(USUARIO_KEY) == null) {
            usuario = usuarios.novo();

            session(USUARIO_KEY, "" + usuario.getId());
        } else {
            usuario = recuperar();
        }

        return usuario;
    }

    public static Usuario recuperar() {
        long id = Long.parseLong(session(USUARIO_KEY));
        return usuarios.recuperar(id);
    }

    public static long getIdFromSession() {
        return Long.parseLong(session(USUARIO_KEY));
    }
}
