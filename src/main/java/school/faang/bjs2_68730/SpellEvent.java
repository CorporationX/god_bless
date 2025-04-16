package school.faang.bjs2_68730;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@ToString
class SpellEvent {
    private static AtomicInteger counter = new AtomicInteger(0);
    @Getter
    private final Integer id;
    @Getter
    private final EventType eventType;
    private final String action;

    public SpellEvent(EventType eventType, String action) {
        this.id = counter.incrementAndGet();
        this.eventType = eventType;
        this.action = action;
    }
}
