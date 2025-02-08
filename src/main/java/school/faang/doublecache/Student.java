package school.faang.doublecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Student {
    private final String name;

    public Student(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new NullPointerException("Значение имени студента не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }
    }
}
