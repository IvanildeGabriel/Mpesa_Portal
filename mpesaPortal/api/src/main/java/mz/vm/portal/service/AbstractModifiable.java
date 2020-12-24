package mz.vm.portal.service;

import mz.vm.portal.exception.IllegalActivityException;
import mz.vm.portal.exception.ValidationException;
import mz.vm.portal.util.ExceptionUtils;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractModifiable<E extends Persistable<I>, I extends Number> implements Modifiable<E, I> {

    private final JpaRepository<E, I> repository;

    public AbstractModifiable(JpaRepository<E, I> repository) {
        this.repository = repository;
    }

    @Override
    public E create(E entity) throws ValidationException, IllegalActivityException {
        ExceptionUtils.persistableNotNull(entity);
        if (!entity.isNew()) throw new IllegalActivityException("The Entity already exist, Please, try to update.");
        return repository.save(entity);
    }

    @Override
    public void delete(I id) throws ValidationException {
        ExceptionUtils.idNotNullAndGreaterThanZero(id);
        repository.deleteById(id);
    }

    @Override
    public E update(E entity) throws ValidationException, IllegalActivityException {
        ExceptionUtils.persistableNotNull(entity);
        if (entity.isNew()) throw new IllegalActivityException("The Entity must be created first.");
        return repository.save(entity);
    }
}
