package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public record Comment(
        int id,
        String text,
        @NonNull User author,
        LocalDateTime timestamp
) {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public Comment {
        if (id == 0) {
            id = COUNTER.incrementAndGet();
        }
        timestamp = Optional.ofNullable(timestamp).orElseGet(LocalDateTime::now);

        if (text.isBlank()) {
            throw new IllegalArgumentException("Комментарий не может быть пустым");
        }
    }

    public Comment(String commentText, @NonNull User author) {
        this(0, commentText, author, null);
    }
}