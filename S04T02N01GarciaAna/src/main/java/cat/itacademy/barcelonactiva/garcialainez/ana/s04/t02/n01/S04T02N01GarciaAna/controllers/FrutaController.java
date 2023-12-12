package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.controllers;

import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.FrutaNotFoundException;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.domain.Fruta;
import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.services.FrutaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaServices frutaServices;

    @PostMapping("/add")
    public ResponseEntity<Fruta> createFruta(@RequestBody Fruta fruta) {
        Fruta nuevaFruta = frutaServices.addFruta(fruta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFruta);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruta(@PathVariable Long id, @RequestBody Fruta frutaActualizada) {
        try {
            frutaServices.updateFruta(id, frutaActualizada);
            return ResponseEntity.ok("Fruta actualizada exitosamente");
        } catch (FrutaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        List<Fruta> frutas = frutaServices.getAllFrutas();
        return ResponseEntity.ok(frutas);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> searchFrutaById(@PathVariable Long id) {
        Fruta fruta = frutaServices.getFrutaById(id);
        return ResponseEntity.of(Optional.ofNullable(fruta));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFrutaById(@PathVariable Long id) {
        frutaServices.deleteFruta(id);
        return ResponseEntity.noContent().build();
    }

}
/* @Autowired--indica que inyecta FrutaServices a FrutaController
*  @PostMapping--indica que este metodo va ser un endpoint de mi apirest y vamos a guardar este objeto
* @RequestBody--indica que vamos a recibir una data en formato json y que tiene que transformarla en una clase java*/