package unoeste.fipp.mercadofipp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pergunta_anuncio")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long Id;
    @Column(name = "per_text")
    private String texto;
    @Column(name = "per_resp")
    private String resposta;
    @ManyToOne
    @JoinColumn(name = "anu_id")
    private Anuncio anuncio;

    public Pergunta(Long id, String texto, String resposta, Anuncio anuncio) {
        Id = id;
        this.texto = texto;
        this.resposta = resposta;
        this.anuncio = anuncio;
    }

    public Pergunta() {
        this(0L,"","",null);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}