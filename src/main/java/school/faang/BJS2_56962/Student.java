package school.faang.BJS2_56962;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Student {

    private final String name;

    public Student(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }

        this.name = name;
    }
}
