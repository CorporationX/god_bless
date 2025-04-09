package school.faang.bjs2_68750;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final Integer id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = createId();
        this.eventType = eventType;
        this.action = action;
    }

    public static Integer createId() {
        return idCounter.getAndIncrement();
    }
}
