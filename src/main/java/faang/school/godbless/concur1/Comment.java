package faang.school.godbless.concur1;

import java.time.LocalDateTime;

public record Comment(int id, String text, LocalDateTime timeAndDate, String author) {
}
