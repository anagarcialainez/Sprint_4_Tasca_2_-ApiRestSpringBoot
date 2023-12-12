package cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.repository;

import cat.itacademy.barcelonactiva.garciaLainez.ana.s04.t02.n02.S04T02N02GarciaLainezAna.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta,Long> {

}
