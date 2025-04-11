package school.faang.bjs2_68745;

import java.util.NoSuchElementException;

public record Subject(String name) {
    public static final String NAME_IS_EMPTY = "Subject name is empty";

    public Subject {
        if (name == null || name.isBlank()) {
            throw new NoSuchElementException(NAME_IS_EMPTY);
        }
    }
}
