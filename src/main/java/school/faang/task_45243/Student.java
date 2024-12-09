package school.faang.task_45243;

import lombok.NonNull;

public record Student(int id, @NonNull String name) {
    public Student {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
