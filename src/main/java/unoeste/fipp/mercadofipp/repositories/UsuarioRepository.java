package unoeste.fipp.mercadofipp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unoeste.fipp.mercadofipp.entities.Usuario;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha")
    public Usuario findByNomeAndSenha(@Param("nome") String nome, @Param("senha") String senha);

    Usuario findByNome(String nome);
}
