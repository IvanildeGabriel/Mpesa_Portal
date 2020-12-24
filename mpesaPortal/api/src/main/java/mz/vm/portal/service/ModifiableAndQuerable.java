package mz.vm.portal.service;

import org.springframework.data.domain.Persistable;

public interface ModifiableAndQuerable<E extends Persistable<I>, I> extends Querable<E, I>, Modifiable<E, I> {

}
