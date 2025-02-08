package school.faang.BJS2_56962;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Subject {

    private final String name;

    public Subject(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Название предмета не может быть пустым");
        }

        this.name = name;
    }
}
