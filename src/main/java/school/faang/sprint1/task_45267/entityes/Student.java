package school.faang.sprint1.task_45267.entityes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@ToString
@EqualsAndHashCode
public class Student {
    private static int idCounter = 1;
    @EqualsAndHashCode.Exclude
    private final int id;
    private final String name;

    public Student(String name) {
        this.id = idCounter++;
        this.name = name;
    }
}
