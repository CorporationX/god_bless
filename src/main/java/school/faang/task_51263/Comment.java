package school.faang.task_51263;

import lombok.NonNull;

import java.time.LocalDateTime;

public record Comment(@NonNull String text,
                      @NonNull String author,
                      @NonNull LocalDateTime timestamp) {

    public Comment {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");

        }
    }

}
