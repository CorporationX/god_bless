package school.faang.bjs245208;

import java.util.Objects;
import java.util.UUID;

public class Helpers {
    public static void notEmptyParamsCheck(Object... toCheck) {
        for (Object obj : toCheck) {
            if (obj == null || (obj instanceof String) && ((String) obj).isEmpty()) {
                throw new IllegalArgumentException("Cannot operate request as all required fields are not set!");
            }
        }
    }

    public static <T> void notEmptyParamCheck(T toCheck, String name) {
        if (toCheck == null || toCheck instanceof String && ((String) toCheck).isEmpty()) {
            throw new IllegalArgumentException(String.format("Cannot operate request as %s is not set!", name));
        }
    }

    public static boolean objectEqualsUuidOrString(UUID id, String name, UUID idValue, String nameValue){
        return id != null ? Objects.equals(id, idValue) : Objects.equals(name, nameValue);
    }
}
