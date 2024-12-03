package school.faang.sprint_1.task_bjs243837;

public class CharacterValidator {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;

    private CharacterValidator() {
    }

    public static void validateName(String name) {
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
