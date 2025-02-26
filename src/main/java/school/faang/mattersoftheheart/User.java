package school.faang.mattersoftheheart;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private static final int MIN_NAME_LENGTH = 3;

    private final String name;
    private boolean isOnline = true;
    private boolean isLookingForChat = true;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        Objects.requireNonNull(name, "Invalid user name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name don't contain any characters");
        } else if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("Name length must be at least 3 characters");
        }
    }
}
