package school.faang.catchevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {

    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        this.id = id;
    }
}