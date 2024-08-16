package faang.school.godbless.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Employee {
    private final String name;
    private final int salary;
    private final String department;
}
