package mz.vm.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends EntityNotFoundException implements Supplier<Exception> {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("The Resource is Not Found");
    }

    @Override
    public ResourceNotFoundException get() {
        return new ResourceNotFoundException("The Resource is Not Found");
    }
}
