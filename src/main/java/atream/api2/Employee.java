package atream.api2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Employee {
    private final String name;
    private final double salary;
    private final String department;
}
