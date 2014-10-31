package repositories;

import models.Voto;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;

/**
 * Created by brg on 26/10/2014.
 */
public class Votos implements VotoRepository {

    private EntityManager entityManager;

    public Votos(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Votos() {
    }

    @Override
    public void salvar(Voto voto) {
        getEntityManager().persist(voto);
    }

    private EntityManager getEntityManager() {
        if(entityManager == null) {
            return JPA.em();
        }

        return entityManager;
    }
}
