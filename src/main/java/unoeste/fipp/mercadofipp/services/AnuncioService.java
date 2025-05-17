package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Foto;
import unoeste.fipp.mercadofipp.entities.Pergunta;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;
import unoeste.fipp.mercadofipp.repositories.FotoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private FotoRepository fotoRepository;

    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
    }

    public Anuncio add(Anuncio anuncio){
        if(anuncio.getFotos() != null){
            for(Foto foto: anuncio.getFotos()){
                foto.setAnuncio(anuncio);
            }
        }
        return anuncioRepository.save(anuncio);
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

    public Optional<Anuncio> findById(Long anuId) {
        return anuncioRepository.findById(anuId);
    }

    public void salvarFoto(Foto novaFoto) {
        fotoRepository.save(novaFoto);
    }
}
