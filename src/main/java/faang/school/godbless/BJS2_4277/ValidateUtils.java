package faang.school.godbless.BJS2_4277;

import java.util.Collections;
import java.util.Set;

public class ValidateUtils {

    public static Long generateId(Set<Long> id) {
        Long nextId = id.isEmpty() ? 1 : Collections.max(id) + 1;
        id.add(nextId);
        return nextId;
    }

    public static void validateData(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is not be empty");
        }
    }
}
