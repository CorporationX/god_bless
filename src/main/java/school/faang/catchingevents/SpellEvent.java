package school.faang.catchingevents;

import lombok.Getter;

@Getter
public class SpellEvent {

    private static int nextId = 1;

    public SpellEvent(EventType eventType, String action) {
        this.id = nextId++;
        this.eventType = eventType;
        this.action = action;
    }

    private final int id;
    private final EventType eventType;
    private final String action;
}
