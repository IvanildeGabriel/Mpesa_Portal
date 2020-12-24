package mz.vm.mpesa.service;

public abstract class AbstractModifyAndQueryServiceCaller<T, I> extends AbstractQueryServiceCaller<T, I> implements IModifyServiceCaller<T, I> {
    public abstract T update(T info);

    public abstract boolean delete(I id);
}