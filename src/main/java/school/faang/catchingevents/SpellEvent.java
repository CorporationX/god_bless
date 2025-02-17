package school.faang.catchingevents;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {

    private static int nextId = 1;

    private final int id;
    private final EventType eventType;
    private final String action;

    public SpellEvent(EventType eventType, String action) {
        this.id = nextId++;
        this.eventType = eventType;
        this.action = action;
    }
}
