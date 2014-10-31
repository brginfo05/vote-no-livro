package controllers;

import models.Usuario;
import models.VotoConsolidado;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.VotoConsolidadoRepository;
import repositories.Votos;
import repositories.VotosConsolidados;
import services.VotoService;

import java.util.List;

/**
 * Created by brg on 26/10/2014.
 */
public class RankingController extends Controller {

    private static VotoConsolidadoRepository votosConsolidados = new VotosConsolidados();
    //TODO IOC
    private static VotoService votoService = new VotoService(new Votos());


    @Transactional
    public static Result exibir() {
        List<VotoConsolidado> rankingGeral = votosConsolidados.recuperar();
        List<VotoConsolidado> rankingUsuario = votosConsolidados.recuperar(UsuarioController.recuperar());

        return ok(views.html.ranking.render(rankingGeral, rankingUsuario));
    }

    @Transactional
    public static Result votar(int idVotado, int idNaoVotado) {
        Usuario usuario = UsuarioController.recuperar();
        votoService.votar(idVotado, idNaoVotado, usuario);

        return redirect(routes.ApplicationController.main());
    }
}
