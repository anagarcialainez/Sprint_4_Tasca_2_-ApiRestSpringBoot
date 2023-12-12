package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.repository;

import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta,Long> {

}

/*@Repository--indica a spring que esta interfaz es un repositorio
* JpaRepository<Fruta,Long> ---clase que nos permitira hacer el CRUD a través de sus métodos, se indica la clase y el tipo de dato de la FK
* */