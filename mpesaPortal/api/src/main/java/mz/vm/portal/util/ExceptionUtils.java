package mz.vm.portal.util;

import mz.vm.portal.exception.ValidationException;
import org.springframework.data.domain.Persistable;

public final class ExceptionUtils {
    public static void persistableNotNull(Persistable entity) throws ValidationException {
        if (entity == null) throw new ValidationException("The Entity should not be null.");
    }
    public static void idNotNullAndGreaterThanZero(Number id) throws ValidationException {
        if (id == null) throw new ValidationException("The ID should not be null.");
        else if (id.longValue() <= 0) throw new ValidationException("The Id must be > 0.");
    }
}
