package school.faang.bjs2_75935;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class Utils {
    public static final BiFunction<String, String, StringBuilder> VALIDATE_TEXT =
        (textField, errorMessage, errorBuilder) -> {
        if (textField == null || textField.isBlank()) {
            if (!errorBuilder.isEmpty()) {
                errorBuilder.append(" ");
            }
            errorBuilder.append(errorMessage);
        }
        return errorBuilder;
    };

    public static final BiFunction<Object, String, StringBuilder> VALIDATE_OBJECT =
        (object, errorMessage, errorBuilder) -> {
            if (object == null) {
                if (!errorBuilder.isEmpty()) {
                    errorBuilder.append(" ");
                }
                errorBuilder.append(errorMessage);
            }
            return errorBuilder;
        };

    private Utils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
