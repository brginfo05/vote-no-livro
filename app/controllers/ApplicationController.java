package controllers;

import models.Dupla;
import models.Livro;
import models.Usuario;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.LivroRepository;
import repositories.Livros;
import services.LivroService;
import views.html.index;

public class ApplicationController extends Controller {

    private static LivroService livroService = new LivroService();

    @Transactional
    public static Result index() {
        Usuario usuario = UsuarioController.criar();
        Dupla dupla = livroService.recuperarDupla(usuario);

        if (dupla == null) {
            return usuario.isCadastrado() ? redirect(routes.RankingController.exibir()) : ok(views.html.cadastroUsuario.render());
        }

        return ok(index.render(dupla.getPrimeiroLivro(), dupla.getSegundoLivro()));
    }


}
