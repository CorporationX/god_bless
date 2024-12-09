package school.faang.bjs245208;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidatorUtil {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> boolean validate(T object) {

        if (object == null) {
            String message = "Validation failed: object is null!";
            //throw new IllegalArgumentException(message);
            System.err.println(message);
            return false;
        }

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            //throw new IllegalArgumentException(sb.toString());
            System.err.println("Validation failed: " + sb.toString());
            return false;
        }
        return  true;
    }
}
