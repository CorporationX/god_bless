package school.faang.stream.api.three;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private double salary;
    private String department;
}
