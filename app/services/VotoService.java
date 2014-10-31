package services;

import models.Livro;
import models.Usuario;
import models.Voto;
import play.db.jpa.JPA;
import repositories.VotoRepository;
import repositories.Votos;

/**
 * Created by brg on 30/10/2014.
 */
public class VotoService {

    //TODO IOC
    private VotoRepository votos;

    public VotoService(VotoRepository votos) {
        this.votos = votos;
    }

    public void votar(int idVotado, int idNaoVotado, Usuario usuario) {
        Livro livroVotado = new Livro(idVotado);
        Livro livroNaoVotado = new Livro(idNaoVotado);

        votos.salvar(new Voto(livroVotado, true, livroNaoVotado, usuario));
        votos.salvar(new Voto(livroNaoVotado, false, livroVotado, usuario));
    }
}
