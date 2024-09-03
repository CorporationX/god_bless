package faang.school.godbless.BJS2_25438;

import java.time.LocalDateTime;

public record Comment(long id, String text, LocalDateTime commentDate, Author author) {
}
