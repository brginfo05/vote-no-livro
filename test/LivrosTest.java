import models.Livro;
import models.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.db.jpa.Transactional;
import play.test.FakeApplication;
import repositories.Livros;
import repositories.Usuarios;
import repositories.Votos;
import services.VotoService;

import javax.persistence.EntityManager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.start;

/**
 * Created by brg on 30/10/2014.
 */
public class LivrosTest{

    private EntityManager em;

    @Before
    public void setUpIntegrationTest() {
        FakeApplication app = fakeApplication();
        start(app);
        em = app.getWrappedApplication().plugin(JPAPlugin.class).get().em("test");
        JPA.bindForCurrentThread(em);
    }

    @After
    public void tearDownIntegrationTest() {
        JPA.bindForCurrentThread(null);
        em.close();
    }

    @Test
     public void naoRepetirCombinacao() {
        Livro primeiroLivro = new Livro(1);
        Livro segundoLivro = new Livro(2);

        em.getTransaction().begin();

        em.persist(primeiroLivro);
        em.persist(segundoLivro);
        Usuario usuario = new Usuarios(em).novo();
        new VotoService(new Votos(em)).votar(primeiroLivro.getISBN(), segundoLivro.getISBN(), usuario);

        em.getTransaction().commit();

        assertThat("Não deve repetir a combinação",new Livros().recuperarSegundoLivro(usuario, primeiroLivro), is(nullValue()));
    }
}
