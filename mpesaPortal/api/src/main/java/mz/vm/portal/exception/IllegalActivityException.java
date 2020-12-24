package mz.vm.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalActivityException extends RuntimeException {
    public IllegalActivityException(String message) {
        super(message);
    }
}
