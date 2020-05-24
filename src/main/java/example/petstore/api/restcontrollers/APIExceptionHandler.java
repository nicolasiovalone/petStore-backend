package example.petstore.api.restcontrollers;

import example.petstore.exceptions.PetRepositoryException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PetRepositoryException.class})
    public ResponseEntity<Object> petRepositoryExceptionHandler(PetRepositoryException petRepositoryException) {
        return new ResponseEntity<Object>(petRepositoryException.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
