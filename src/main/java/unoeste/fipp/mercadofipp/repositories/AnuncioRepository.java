package unoeste.fipp.mercadofipp.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unoeste.fipp.mercadofipp.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pergunta_anuncio (anu_id, per_text) VALUES (:id_anuncio, :texto)", nativeQuery = true)
    public void addPergunta(@Param("id_anuncio") Long id_anuncio, @Param("texto") String texto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE pergunta_anuncio SET per_resp = :texto WHERE per_id = :id_pergunta", nativeQuery = true)
    public void addResposta(@Param("id_pergunta") Long id_pergunta, @Param("texto") String texto);
}
