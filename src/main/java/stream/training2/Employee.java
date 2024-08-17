package stream.training2;

import lombok.Data;
import lombok.NonNull;

@Data
public class Employee {
    @NonNull
    private final String name;
    @NonNull
    private final String department;
    private final double salary;

}
