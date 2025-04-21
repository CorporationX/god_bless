package school.faang.streamapithree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
    private final String name;
    private int salary;
    private String department;
}
