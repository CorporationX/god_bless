package school.faang.task_46698;

import lombok.NonNull;

public record Notification(@NonNull String type, @NonNull String message) {
    public Notification {
        if (type.isBlank() || message.isBlank()) {
            throw new IllegalArgumentException("Type and message must not be blank.");
        }
    }
}
