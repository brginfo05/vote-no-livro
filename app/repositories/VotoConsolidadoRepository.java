package repositories;

import models.Usuario;
import models.VotoConsolidado;

import java.util.List;

/**
 * Created by brg on 27/10/2014.
 */
public interface VotoConsolidadoRepository {
    List<VotoConsolidado> recuperar();

    List<VotoConsolidado> recuperar(Usuario usuario);
}
