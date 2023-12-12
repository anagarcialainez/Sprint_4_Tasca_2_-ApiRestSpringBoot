package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.repository;

import cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n03.S04T02N03GarciaAna.model.domain.Fruta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaMongoRepository extends MongoRepository<Fruta,String> {

}
