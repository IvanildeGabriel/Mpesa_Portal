package mz.vm.portal.util;

import org.modelmapper.ModelMapper;
public final class InfoUtils {

    /**
     * Converter of objects
     * @param object
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T toInfo(Object object, Class<T> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, tClass);
    }
}
