package faang.school.godbless.task.multithreading.async.leave.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@ToString
@RequiredArgsConstructor
public class Comment {
    private final User author;
    private final String content;
    private static final AtomicLong idCounter = new AtomicLong();
    private final long id = idCounter.incrementAndGet();
    private final LocalDateTime createdAt = LocalDateTime.now();
}
