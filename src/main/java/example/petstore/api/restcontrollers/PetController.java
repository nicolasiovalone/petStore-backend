package example.petstore.api.restcontrollers;

import example.petstore.exceptions.PetRepositoryException;
import example.petstore.persistance.dto.PetDTO;
import example.petstore.persistance.entities.Pet;
import example.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PetController {

    private final PetService petService;

    /**
     * Constructor
     *
     * @param petService
     */
    @Autowired
    public PetController(final PetService petService) {
        this.petService = petService;
    }

    /**
     * Get all pets
     *
     * @return List<Pet>
     */
    @GetMapping("/pets")
    public List<Pet> getPets() {
        return (List<Pet>) petService.findAll();
    }

    /**
     * Add a new pet
     *
     * @param petDTO
     * @return ResponseEntity
     * @throws PetRepositoryException
     */
    @PostMapping("/pet")
    public ResponseEntity addPet(@RequestBody PetDTO petDTO) throws PetRepositoryException {
        petService.save(petDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Get the existence of a pet by breed
     *
     * @param breed
     * @return boolean
     * @throws PetRepositoryException
     */
    @GetMapping("/ispetexist")
    public boolean isPetExist(@RequestParam String breed) throws PetRepositoryException {
        return petService.isPetExist(breed);
    }

    /**
     * Delete a pet by breed
     *
     * @param breed
     * @return ResponseEntity
     * @throws PetRepositoryException
     */
    @PostMapping("/deletepet")
    public ResponseEntity deletePet(@RequestParam String breed) throws PetRepositoryException {
        petService.delete(breed);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Increase the quantity of the pet
     *
     * @param breed
     * @param quantity
     * @return ResponseEntity
     * @throws PetRepositoryException
     */
    @PostMapping("/pet/addquantity")
    public ResponseEntity addQuantity(@RequestParam String breed, @RequestParam String quantity) throws PetRepositoryException {
        petService.addQuantity(breed, quantity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Decrease the quantity of the pet
     *
     * @param breed
     * @param quantity
     * @return ResponseEntity
     * @throws PetRepositoryException
     */
    @PostMapping("/pet/decreasequantity")
    public ResponseEntity decreaseQuantity(@RequestParam String breed, @RequestParam String quantity) throws PetRepositoryException {
        petService.decreaseQuantity(breed, quantity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Get a pet by breed
     *
     * @param breed
     * @return Pet
     * @throws PetRepositoryException
     */
    @GetMapping("/pet/getpet")
    public Pet getPet(@RequestParam String breed) throws PetRepositoryException {
        return petService.findPet(breed);
    }

    /**
     * Set the description of the pet
     *
     * @param breed
     * @param description
     * @return ResponseEntity
     * @throws PetRepositoryException
     */
    @PostMapping("/pet/updatedescription")
    public ResponseEntity setDescription(@RequestParam String breed, @RequestParam String description) throws PetRepositoryException {
        petService.setDescription(breed, description);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
