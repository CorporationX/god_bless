package faang.school.godbless.sprint3.streamAPI.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    private String name;

    private int salary;

    private String department;
}
