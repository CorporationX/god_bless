package school.faang.catchevents;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {

    private final int id;
    private final EventType eventType;
    private final String action;

    public SpellEvent(int id, EventType eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        this.id = id;
    }
}