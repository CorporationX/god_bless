package school.faang.catching_events;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private static int nextId = 1;
    private final Integer id;
    private final String eventType;
    private final String action;

    protected SpellEvent(String eventType, String action) {
        this.id = getNextId();
        this.eventType = eventType;
        this.action = action;
    }

    private static int getNextId() {
        return nextId++;
    }
}
