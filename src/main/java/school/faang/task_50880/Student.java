package school.faang.task_50880;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;
}
