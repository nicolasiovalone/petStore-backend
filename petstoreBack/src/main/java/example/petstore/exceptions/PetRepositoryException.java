package example.petstore.exceptions;

public class PetRepositoryException extends Exception{

    /**
     * Constructor
     *
     * @param message
     */
    public PetRepositoryException(String message) {
        super(message);
    }

}
