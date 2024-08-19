package faang.school.godbless.sprint.two.streamapi2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Employee {
    private final String name;
    private final double salary;
    private final String department;
}
