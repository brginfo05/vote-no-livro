package repositories;

import models.Usuario;

/**
 * Created by brg on 27/10/2014.
 */
public interface UsuarioRepository {
    Usuario recuperar(long id);

    Usuario novo();

    Usuario salvar(Usuario usuario);
}
