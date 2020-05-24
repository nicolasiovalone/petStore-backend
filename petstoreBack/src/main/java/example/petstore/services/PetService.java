package example.petstore.services;

import example.petstore.exceptions.PetRepositoryException;
import example.petstore.persistance.dto.PetDTO;
import example.petstore.persistance.entities.Pet;
import example.petstore.persistance.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Add a new pet
     *
     * @param petDTO
     * @throws PetRepositoryException
     */
    public void save(final PetDTO petDTO) throws PetRepositoryException {
        if(petRepository.existsById(petDTO.getBreed())) {
            throw new PetRepositoryException("Error : this pet is already existing");
        }

        Pet pet = new Pet(petDTO);
        petRepository.save(pet);
    }

    /**
     * Delete an existing pet
     *
     * @param breed
     * @throws PetRepositoryException
     */
    public void delete(final String breed) throws PetRepositoryException {
        this.findPet(breed);

        petRepository.deleteById(breed);
    }

    /**
     * Get all pets
     *
     * @return List<Pet>
     */
    public List<Pet> findAll() {
        return (List<Pet>) this.petRepository.findAll();
    }

    /**
     * Add quantity to the pet
     *
     * @param breed
     * @param quantity
     * @throws PetRepositoryException
     */
    public void addQuantity(final String breed, final String quantity) throws PetRepositoryException {
        Pet pet = this.findPet(breed);
        PetDTO petDTO = new PetDTO(pet);

        petDTO.increaseQuantity(Integer.parseInt(quantity));
        petRepository.save(new Pet(petDTO));
    }

    /**
     * Decrease quantity to the pet
     *
     * @param breed
     * @param quantity
     * @throws PetRepositoryException
     */
    public void decreaseQuantity(final String breed, final String quantity) throws PetRepositoryException {
        Pet pet = this.findPet(breed);
        PetDTO petDTO = new PetDTO(pet);

        long quantityAfterDecrease = petDTO.getQuantity()-Integer.parseInt(quantity);
        if(quantityAfterDecrease < 0) {
            throw new PetRepositoryException("Error : there isn't enought quantity");
        }

        petDTO.decreaseQuantity(Integer.parseInt(quantity));
        petRepository.save(new Pet(petDTO));
    }

    /**
     * Set description of the pet
     *
     * @param breed
     * @param description
     * @throws PetRepositoryException
     */
    public void setDescription(final String breed, final String description) throws PetRepositoryException {
        Pet pet = this.findPet(breed);
        pet.setDescription(description);
        petRepository.save(pet);
    }

    /**
     * Get pet by breed
     *
     * @param breed
     * @return Pet
     * @throws PetRepositoryException
     */
    public Pet findPet(final String breed) throws PetRepositoryException {
        return petRepository.findById(breed).orElseThrow(()->new PetRepositoryException("Error : this pet is not existing"));
    }

    /**
     * Get the existence of a pet
     *
     * @param breed
     * @return boolean
     * @throws PetRepositoryException
     */
    public boolean isPetExist(final String breed) throws PetRepositoryException {
        return petRepository.existsById(breed);
    }
}
