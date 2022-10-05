import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LerHistoria{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Character tipo;
    
    
    @OneToOne(mappedBy = "LerHistoria") 
    private Historia historia;
    
    public LerHistoria() {
    }

    public LerHistoria(Long id, Character tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }
}
