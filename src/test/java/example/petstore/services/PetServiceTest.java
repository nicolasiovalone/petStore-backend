package example.petstore.services;

import example.petstore.exceptions.PetRepositoryException;
import example.petstore.persistance.dto.PetDTO;
import example.petstore.persistance.entities.Pet;
import example.petstore.persistance.repository.PetRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PetRepository petRepositoryMock = mock(PetRepository.class);
    private PetService petServiceSpy = spy(new PetService(petRepositoryMock));

    @Test
    public void negativeQuantityTest() throws PetRepositoryException {
        Pet petMock = new Pet("Dog", "Dog's description", 5);
        doReturn(petMock).when(petServiceSpy).findPet(anyString());

        expectedException.expect(PetRepositoryException.class);
        expectedException.expectMessage("Error : there isn't enough quantity");

        petServiceSpy.decreaseQuantity("Dog", "10");
    }

    @Test
    public void positiveQuantityTest() throws PetRepositoryException {
        Pet petMock = new Pet("Dog", "Dog's description", 5);
        doReturn(petMock).when(petServiceSpy).findPet(anyString());

        petServiceSpy.decreaseQuantity("Dog", "1");

        verify(petRepositoryMock, times(1)).save(any(Pet.class));
    }

    @Test
    public void addExistingPetTest() throws PetRepositoryException {
        doReturn(true).when(petRepositoryMock).existsById(anyString());

        expectedException.expect(PetRepositoryException.class);
        expectedException.expectMessage("Error : this pet is already existing");

        petServiceSpy.save(new PetDTO(new Pet("Bird", "Bird's description", 20)));
    }
}