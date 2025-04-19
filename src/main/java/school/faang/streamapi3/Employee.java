package school.faang.streamapi3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer salary;
    private String department;
}
