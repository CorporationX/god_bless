package commenting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private static final AtomicInteger idCount = new AtomicInteger(0);
    private final int id = idCount.incrementAndGet();
    private String text;
    private final LocalDateTime timestamp;
    private final String author;
}
