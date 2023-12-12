package cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.services;

import cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.domain.Fruta;
import cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FrutaServices {
    @Autowired
    private FrutaRepository frutaRepository;

    //Métodos CRUD
    public Fruta addFruta(Fruta fruta){

        return frutaRepository.save(fruta);
    }

    public void updateFruta(Long id, Fruta frutaActualizada) {

        if (!frutaRepository.existsById(id)) {
            throw new FrutaNotFoundException("Fruta no encontrada con ID: " + id);
        }
        frutaActualizada.setId(id);

        // Actualizar la fruta
        frutaRepository.save(frutaActualizada);
    }

    public Fruta getFrutaById(Long id){
        Optional<Fruta> frutaOptional = frutaRepository.findById(id);

        return frutaOptional.get();
    }

    public List<Fruta> getAllFrutas(){
        return frutaRepository.findAll();
    }

    public void deleteFruta(Long id){
        frutaRepository.deleteById(id);
    }
}