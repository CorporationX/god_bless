package school.faang.task_45547;

import lombok.NonNull;

public record Item(@NonNull String name, int value) {
    public Item {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
    }

}
