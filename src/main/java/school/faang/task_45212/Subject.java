package school.faang.task_45212;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Subject {
    private final int id;
    private final String name;

    public Subject(int id, String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Наименование не может быть пустым");
        }

        this.id = id;
        this.name = name;
    }
}
