package faang.school.godbless.concurrency.comment;

import java.time.LocalDateTime;

public record Comment(String text, LocalDateTime dateTime, String author) {
}
