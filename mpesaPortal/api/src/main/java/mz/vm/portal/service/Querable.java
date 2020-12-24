package mz.vm.portal.service;

import mz.vm.portal.exception.ResourceNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public interface Querable<E, I> extends Serializable {

    E findById(I id) throws ResourceNotFoundException;

    Collection<E> findAll() throws ResourceNotFoundException;

}
