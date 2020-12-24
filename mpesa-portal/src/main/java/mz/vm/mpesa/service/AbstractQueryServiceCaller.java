package mz.vm.mpesa.service;
import java.util.List;

public abstract class AbstractQueryServiceCaller<T,I> extends AbstractServiceCaller {
    public abstract T finById(I id);
    public abstract List<T> finAll();
}