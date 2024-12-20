package school.faang.bjs_46821;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private final String name;
    @Setter
    private double salary;
    @Setter
    private String department;
}
