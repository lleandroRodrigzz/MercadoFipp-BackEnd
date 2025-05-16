package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Pergunta;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;

import java.util.List;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
    }

    public Anuncio add(Anuncio anuncio){
        Anuncio novoAnuncio = anuncioRepository.save(anuncio);
        //agr grave as fotos na tabela de fotos
        //for ...
        //anuncioRepository.addFoto(...);
        return novoAnuncio;
    }

    public boolean addPergunta(Long idAnuncio, String texto){
        try {
            anuncioRepository.addPergunta(idAnuncio, texto);
            return true;
        }
        catch (Exception e){
            e.printStackTrace(); //<-- LOG PARA ERRO
            return false;
        }
    }

    public boolean addResposta(Long idPergunta, String texto) {
        try {
            anuncioRepository.addResposta(idPergunta,texto);
            return true;
        }
        catch (Exception e){
            e.printStackTrace(); //<-- LOG PARA ERRO
            return false;
        }
    }
}
