package school.faang.sprint_1.task_45202;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Subject {
    private static int count = 0;
    private final int id;
    private final String name;

    public Subject(String name) {
        this.name = name;
        id = count;
        count++;
    }
}
