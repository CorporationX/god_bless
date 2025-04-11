package school.faang.bjs2_68745;

import java.util.NoSuchElementException;

public record Student(String name) {
    public static final String NAME_IS_EMPTY = "Student name is empty";

    public Student {
        if (name == null || name.isBlank()) {
            throw new NoSuchElementException(NAME_IS_EMPTY);
        }
    }
}
