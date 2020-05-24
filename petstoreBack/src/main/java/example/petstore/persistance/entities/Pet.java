package example.petstore.persistance.entities;

import example.petstore.persistance.dto.PetDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {

    @Id
    private String breed;
    private String description;
    private long quantity;

    /**
     * Constructor
     */
    public Pet() {
    }

    /**
     * Constructor
     *
     * @param breed
     * @param description
     * @param quantity
     */
    public Pet(String breed, String description, long quantity) {
        this.breed = breed;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * Consrtuctor
     *
     * @param petDTO
     */
    public Pet(PetDTO petDTO) {
        this.breed = petDTO.getBreed();
        this.description = petDTO.getDescription();
        this.quantity = petDTO.getQuantity();
    }

    /**
     * Get the breed of the pet
     *
     * @return String
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the pet
     *
     * @param breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Get the description of the pet
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the pet
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the quantity of the pet
     *
     * @return long
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the pet
     *
     * @param quantity
     */
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
