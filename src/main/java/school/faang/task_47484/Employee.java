package school.faang.task_47484;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Employee {

    @NonNull
    private String name;
    @Min(value = 0, message = "Зарплата должна быть не меньше 0")
    private int salary;
    @NonNull
    private String department;

}
