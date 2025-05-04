package school.faang.bjs2_75935;

import java.util.Objects;
import java.util.function.Predicate;

public final class Utils {
    public static final Predicate<String> VALIDATE_TEXT = text -> text == null || text.isBlank();
    public static final Predicate<Object> VALIDATE_OBJECT = Objects::isNull;

    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }
}
