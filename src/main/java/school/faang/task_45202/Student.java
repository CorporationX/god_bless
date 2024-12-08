package school.faang.task_45202;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private static int count = 0;
    private final int id;
    private final String name;

    public Student(String name) {
        this.name = name;
        id = count;
        count++;
    }
}
