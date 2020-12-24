package mz.vm.portal.service;

import mz.vm.portal.exception.IllegalActivityException;
import mz.vm.portal.exception.ValidationException;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

public interface Modifiable<E extends Persistable<I>, I> extends Serializable {
    E create(E entity) throws ValidationException, IllegalActivityException;

    void delete(I id) throws ValidationException;

    E update(E entity) throws ValidationException, IllegalActivityException;

}
