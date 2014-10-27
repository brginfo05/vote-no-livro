package repositories;

import models.Voto;
import play.db.jpa.JPA;

/**
 * Created by brg on 26/10/2014.
 */
public class Votos implements VotoRepository {

    @Override
    public void salvar(Voto voto) {
        JPA.em().persist(voto);
    }
}
