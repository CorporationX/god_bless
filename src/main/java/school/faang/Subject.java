package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Subject {
    private final String name;

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }
    }

    public Subject(String name) {
        validateName(name);
        this.name = name;
    }
}
