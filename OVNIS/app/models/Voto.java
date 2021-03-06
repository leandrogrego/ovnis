package models;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Voto extends Model{

    @ManyToOne
    @JoinColumn(name="idCandidato")
    private Candidato candidato;
    
    @ManyToOne
    @JoinColumn(name="idSecao")
    private Secao secao;
    
    public Voto(Candidato candidato, Secao secao) {
        this.candidato = candidato;
        this.secao = secao;
    }
        public static int getVotosCandidato(Long id) {
        List<Voto> votos = find("idCandidato = ?", id).fetch();
        return votos.size();
    }
    
}
