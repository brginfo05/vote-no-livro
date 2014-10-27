package controllers;

import models.Livro;
import models.Usuario;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.LivroRepository;
import repositories.Livros;
import views.html.index;

public class ApplicationController extends Controller {

    private static LivroRepository livros = new Livros();

    @Transactional
    public static Result index() {
        Usuario usuario = UsuarioController.criar();

        Livro primeiroLivro = livros.recuperarPrimeiroLivro();
        Livro segundoLivro = livros.recuperarSegundoLivro(usuario, primeiroLivro);

        if (primeiroLivro == null || segundoLivro == null) {
            return usuario.isCadastrado() ? redirect(routes.RankingController.exibir()) : ok(views.html.cadastroUsuario.render());
        }

        return ok(index.render(primeiroLivro, segundoLivro));
    }


}
