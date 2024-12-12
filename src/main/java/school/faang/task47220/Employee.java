package school.faang.task47220;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Employee {
    private final String name;
    private final int salary;
    private final Department department;
}
