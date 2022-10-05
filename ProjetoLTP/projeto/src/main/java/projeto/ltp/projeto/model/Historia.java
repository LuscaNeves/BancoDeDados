import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String historia;
    private String titulo;
    private String publicar;
    private String depoimento;

    /* Configuração de relacionamentos com o JPA */
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_lerHistoria")
    private LerHistoria lerHistoria;

    // @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="historia_fk")
    private List<publicar> rotulos = new ArrayList<>();

    // @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "associacao_livro_rotulo", joinColumns = @JoinColumn(name = "fk_historia"), inverseJoinColumns = @JoinColumn(name = "fk_publicar"))
    private List<PublicarMuitosParaMuitos> publicarMuitosParaMuitos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPublicar() {
        return publicar;
    }

    public void setPublicar(String publicar) {
        this.publicar = publicar;
    }

    public String getDepoimento() {
        return depoimento;
    }

    public void setDepoimento(String depoimento) {
        this.depoimento = depoimento;
    }

    public Capa getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public List<Publicar> getPublicar() {
        return publicar;
    }

    public void setPublicar(List<Publicar> publicar) {
        this.publicar = publicar;
    }

    public List<PublicarMuitosParaMuitos> getPublicarMuitosParaMuitos() {
        return publicarMuitosParaMuitos;
    }

    public void setPublicarMuitosParaMuitos(List<PublicarMuitosParaMuitos> publicarMuitosParaMuitos) {
        this.publicarMuitosParaMuitos = publicarMuitosParaMuitos;
    }

    public void addPublicar(Publicar publicar) {
        if (publicar != null) {
            if (publicar == null) {
                publicar = new ArrayList<Publicar>();
            }
            publicar.add(publicar);
            publicar.setHistoria(this);
        }
    }
}
