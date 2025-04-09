package school.faang.bjs2_68750;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class SpellEvent {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private Integer id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = createId();
        this.eventType = eventType;
        this.action = action;
    }

    public static Integer createId() {
        return idCounter.getAndIncrement();
    }
}
