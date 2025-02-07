package school.faang.eventscatching;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static int currentId = 1;
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getAction() {
        return action;
    }
}
