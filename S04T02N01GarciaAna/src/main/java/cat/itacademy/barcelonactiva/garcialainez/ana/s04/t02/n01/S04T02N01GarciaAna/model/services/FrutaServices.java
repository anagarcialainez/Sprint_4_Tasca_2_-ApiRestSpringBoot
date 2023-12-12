package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.services;

import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.domain.Fruta;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.repository.FrutaRepository;
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
        // Verificar si la fruta con el ID proporcionado existe
        if (!frutaRepository.existsById(id)) {
            // lanza una excepción
            throw new FrutaNotFoundException("Fruta no encontrada con ID: " + id);
        }

        // Asignar el ID proporcionado al objeto actualizado
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
 /*Esta clase implementa todos los métodos CRUD
 *  @Autowired --indica que esta sera la variable donde se realizan la inyeccion de dependencias a FrutaServices.
 *  Optional -- para poder utilizar el metodo findById()
 * */