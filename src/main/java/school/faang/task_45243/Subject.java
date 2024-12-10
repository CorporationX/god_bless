package school.faang.task_45243;

import lombok.NonNull;

public record Subject(int id, @NonNull String name) {
    public Subject {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
