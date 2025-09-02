package school.faang.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Set<String> skills;
}
