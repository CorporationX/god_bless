package school.faang.sprint_1.task_bjs245200;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NameValidator {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;

    public static void validateName(String... names) {
        for (String name : names) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name must be not empty");
            }
            if (name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException(
                        "Name must be minimum " + MIN_NAME_LENGTH + " characters long"
                );
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(
                        "Name must be maximum " + MAX_NAME_LENGTH + " characters long"
                );
            }
        }
    }
}
