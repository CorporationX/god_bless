package school.faang.thiredstreamtraining;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Employee {

    @NonNull
    private final String name;
    private final int salary;
    @NonNull
    private final DepartmentType department;
}
