package unoeste.fipp.mercadofipp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "foto_anuncio")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fot_id")
    private Long id;

    @Column(name = "fot_file")
    private String file;

    @ManyToOne
    @JoinColumn(name = "anu_id")
    @JsonIgnore
    private Anuncio anuncio;

    public Foto() {
    }

    public Foto(Anuncio anuncio, String file, Long id) {
        this.anuncio = anuncio;
        this.file = file;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}
