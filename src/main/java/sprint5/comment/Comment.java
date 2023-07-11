package sprint5.comment;

import java.time.LocalDateTime;

public record Comment(String message, LocalDateTime time, String author) {
}
