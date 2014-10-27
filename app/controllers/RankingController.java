package controllers;

import models.Livro;
import models.Usuario;
import models.Voto;
import models.VotoConsolidado;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.VotoConsolidadoRepository;
import repositories.VotoRepository;
import repositories.Votos;
import repositories.VotosConsolidados;

import java.util.List;

/**
 * Created by brg on 26/10/2014.
 */
public class RankingController extends Controller {

    private static VotoConsolidadoRepository votosConsolidados = new VotosConsolidados();
    private static VotoRepository votos = new Votos();


    @Transactional
    public static Result exibir() {
        List<VotoConsolidado> rankingGeral = votosConsolidados.recuperar();
        List<VotoConsolidado> rankingUsuario = votosConsolidados.recuperar(UsuarioController.recuperar());

        return ok(views.html.ranking.render(rankingGeral, rankingUsuario));
    }

    @Transactional
    public static Result votar(int idVotado, int idNaoVotado) {
        Livro livroVotado = new Livro(idVotado);
        Livro livroNaoVotado = new Livro(idNaoVotado);
        Usuario usuario = UsuarioController.recuperar();

        votos.salvar(new Voto(livroVotado, true, livroNaoVotado, usuario));
        votos.salvar(new Voto(livroNaoVotado, false, livroVotado, usuario));

        return redirect(routes.ApplicationController.index());
    }
}
