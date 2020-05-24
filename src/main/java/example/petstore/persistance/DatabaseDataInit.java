package example.petstore.persistance;

import example.petstore.persistance.entities.Pet;
import example.petstore.persistance.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseDataInit implements CommandLineRunner {

    private final PetRepository petRepository;

    @Autowired
    public DatabaseDataInit(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void run(String... args) throws Exception {
        Pet pet1 = new Pet("Dog", "Man's best friend", 10);
        Pet pet2 = new Pet("Cat", "Cute feline", 45);
        Pet pet3 = new Pet("Bird", "Singer flying in the sky", 120);

        this.petRepository.save(pet1);
        this.petRepository.save(pet2);
        this.petRepository.save(pet3);
    }
}
