package school.faang.task_51062;

import lombok.NonNull;

public record Task(@NonNull String name, int difficulty, int reward) {
    public Task {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
