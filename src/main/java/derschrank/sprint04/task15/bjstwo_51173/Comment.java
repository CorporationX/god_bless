package derschrank.sprint04.task15.bjstwo_51173;

import java.time.LocalDateTime;

public record Comment(
        String text,
        Author author,
        LocalDateTime timestamp
) {
}
