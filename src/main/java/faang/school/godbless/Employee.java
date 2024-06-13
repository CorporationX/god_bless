package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final String name;
    private double salary;
    private String departament;
}
