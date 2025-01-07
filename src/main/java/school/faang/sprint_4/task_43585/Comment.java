package school.faang.sprint_4.task_43585;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public record Comment(int id, String text, String author, LocalDateTime timestamp) {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    public Comment(String text, String author, LocalDateTime timestamp) {
        this(ID_GENERATOR.getAndIncrement(), text, author, timestamp);
    }
}