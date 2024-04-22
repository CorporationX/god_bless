package faang.school.godbless.stream_api2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private String department;
    private double salary;
}