package faang.school.godbless.LeaveComment;

import java.time.LocalDateTime;

public record Comment(String text, LocalDateTime dateTime, String author) {
}
