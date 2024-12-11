package school.faang.task_46698;

import lombok.NonNull;

public record Notification(@NonNull NotificationType type, @NonNull String message) {
    public Notification {
        if (message.isBlank()) {
            throw new IllegalArgumentException("Message must not be blank.");
        }
    }

}
