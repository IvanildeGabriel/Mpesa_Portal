package mz.vm.mpesa.service;

import java.io.Serializable;

public interface IModifyServiceCaller<T, I> extends Serializable {
    T save(T info);

    T update(T info);

    boolean delete(I info);
}