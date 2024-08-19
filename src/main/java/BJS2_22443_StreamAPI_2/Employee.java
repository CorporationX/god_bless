package BJS2_22443_StreamAPI_2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    private final String name;
    private final double salary;
    private final String department;
}
