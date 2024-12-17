package school.faang.task_46851;

import lombok.NonNull;

public record Employee(@NonNull String name, double salary, @NonNull String department) {
    public Employee {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

}
