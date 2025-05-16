package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Categoria;
import unoeste.fipp.mercadofipp.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    } //se aqui chega ID, vai alterar

    public Categoria getId(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public boolean delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        try{
            categoriaRepository.delete(categoria);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
