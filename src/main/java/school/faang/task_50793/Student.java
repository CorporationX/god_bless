package school.faang.task_50793;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points;
}
