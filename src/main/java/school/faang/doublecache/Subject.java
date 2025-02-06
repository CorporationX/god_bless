package school.faang.doublecache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Subject {
    private final String name;

    public Subject(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new NullPointerException("Значение названия предмета не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Название предмета не может быть пустым");
        }
    }
}
