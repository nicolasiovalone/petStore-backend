package example.petstore.persistance.dto;

import example.petstore.persistance.entities.Pet;

public class PetDTO {

    private String breed;
    private String description;
    private long quantity;

    /**
     * Constructor
     */
    public PetDTO() {
    }

    /**
     * Constructor
     */
    public PetDTO(Pet pet) {
        this.breed = pet.getBreed();
        this.description = pet.getDescription();
        this.quantity = pet.getQuantity();
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

    /**
     * Increase the quantity of the pet
     *
     * @param quantity
     */
    public void increaseQuantity(long quantity) {
        this.quantity += quantity;
    }

    /**
     * Decrease the quantity of the pet
     *
     * @param quantity
     */
    public void decreaseQuantity(long quantity) {
        this.quantity -= quantity;
    }
}
