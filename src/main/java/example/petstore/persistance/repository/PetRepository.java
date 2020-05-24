package example.petstore.persistance.repository;

import example.petstore.persistance.entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, String> {
}
