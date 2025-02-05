package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Student {
    private final String name;

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }
    }

    public Student(String name) {
        validateName(name);
        this.name = name;
    }
}
