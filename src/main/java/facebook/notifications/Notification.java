package facebook.notifications;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class Notification {
    private static final AtomicInteger idCount = new AtomicInteger(0);
    private final int id;
    private final String message;

    public Notification(@NonNull String message) {
        this.id = idCount.incrementAndGet();
        this.message = message;
    }
}
