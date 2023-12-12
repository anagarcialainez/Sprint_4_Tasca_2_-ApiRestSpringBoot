package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.services;


import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.domain.Fruta;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.repository.FrutaMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrutaServices {
    @Autowired
    private FrutaMongoRepository frutaMongoRepository;

    //Métodos CRUD
    public Fruta addFruta(Fruta fruta){

        return frutaMongoRepository.save(fruta);
    }

    public void updateFruta(String id, Fruta frutaActualizada) {

        if (!frutaMongoRepository.existsById(id)) {
            // Lanza una excepción si la fruta no existe
            throw new FrutaNotFoundException("Fruta no encontrada con ID: " + id);
        }

        // Establece el nuevo ID en la fruta actualizada
        frutaActualizada.setId(id);

        // Actualiza la fruta en la base de datos
        frutaMongoRepository.save(frutaActualizada);
    }

    public Fruta getFrutaById(String id){
        Optional<Fruta> frutaOptional = frutaMongoRepository.findById(id);

        return frutaOptional.get();
    }

    public List<Fruta> getAllFrutas(){
        return frutaMongoRepository.findAll();
    }

    public void deleteFruta(String id){
        frutaMongoRepository.deleteById(id);
    }
}