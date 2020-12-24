package mz.vm.portal.service;

import mz.vm.portal.exception.ResourceNotFoundException;
import mz.vm.portal.util.ExceptionUtils;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractQuerable<E extends Persistable<I>, I extends Number> implements Querable<E, I> {

    protected final JpaRepository<E, I> repository;

    public AbstractQuerable(JpaRepository<E, I> repository) {
        this.repository = repository;
    }

    @Override
    public E findById(I id) throws ResourceNotFoundException {
        ExceptionUtils.idNotNullAndGreaterThanZero(id);
        return repository.getOne(id);
    }

    @Override
    public List<E> findAll() throws ResourceNotFoundException {
        return repository.findAll();
    }
}
