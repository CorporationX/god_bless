package school.faang;

import java.time.LocalDateTime;

public record Comment(String text, String author, LocalDateTime timestamp) {
}
