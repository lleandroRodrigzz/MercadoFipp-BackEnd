package unoeste.fipp.mercadofipp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unoeste.fipp.mercadofipp.entities.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    List<Categoria> id(Long id);
}
