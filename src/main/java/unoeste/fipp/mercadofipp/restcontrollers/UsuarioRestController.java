package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.entities.Usuario;
import unoeste.fipp.mercadofipp.services.UsuarioService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<Usuario> usuarioList = usuarioService.getAll();
        if(usuarioList != null && !usuarioList.isEmpty()){
            return ResponseEntity.ok(usuarioList);
        }
        return ResponseEntity.badRequest().body(new Erro("Usuarios não encontrados"));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getId(@PathVariable Long id){
        Usuario usuario = usuarioService.getId(id);
        if(usuario != null)
            return ResponseEntity.ok(usuario);
        return ResponseEntity.badRequest().body(new Erro("Usuario no encontrado"));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.save(usuario);
        if(novoUsuario != null)
            return ResponseEntity.ok(novoUsuario);
        return ResponseEntity.badRequest().body(new Erro("Erro ao cadastrar usuario"));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Usuario usuario){
        Usuario atualizado = usuarioService.save(usuario);
        if(atualizado != null)
            return ResponseEntity.ok(atualizado);
        return ResponseEntity.badRequest().body(new Erro("Erro ao editar usuário"));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        if(usuarioService.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar o usuario"));
    }
}
