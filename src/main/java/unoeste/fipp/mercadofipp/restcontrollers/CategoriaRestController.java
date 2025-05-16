package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Categoria;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.services.CategoriaService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<Categoria> categoriaList = categoriaService.getAll();
        if(categoriaList!=null && !categoriaList.isEmpty())
            return ResponseEntity.ok(categoriaList);
        return ResponseEntity.badRequest().body(new Erro("categorias não encontradas"));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getId(@PathVariable Long id){
        Categoria categoria = categoriaService.getId(id);
        if(categoria != null)
            return ResponseEntity.ok(categoria);
        return ResponseEntity.badRequest().body(new Erro("categorias não encontradas"));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Categoria categoria){
        Categoria novaCategoria=categoriaService.save(categoria);
        if(categoria!=null)
            return ResponseEntity.ok(categoria);
        return ResponseEntity.badRequest().body("Erro ao cadastrar a categoria");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        if(categoriaService.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar a categoria"));
    }
}
