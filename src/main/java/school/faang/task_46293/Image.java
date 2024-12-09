package school.faang.task_46293;

import lombok.NonNull;

public record Image(@NonNull String name, @NonNull String description) {
    public Image {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
