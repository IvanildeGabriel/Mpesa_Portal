package mz.vm.mpesa.service;

public abstract class AbstractModifyServiceCaller<T, I> extends AbstractServiceCaller implements IModifyServiceCaller<T, I> {
    public abstract T update(T info);

    public abstract boolean delete(I id);
}