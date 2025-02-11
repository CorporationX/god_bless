package school.faang.BJS2_57026;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class SpellEvent {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = counter.getAndIncrement();
        this.eventType = eventType;
        this.action = action;
    }
}