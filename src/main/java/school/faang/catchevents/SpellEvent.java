package school.faang.catchevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class SpellEvent {
    private static int uniqueId = 1;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = uniqueId++;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("id = %d, event type = %s, action = %s ", id, eventType, action);
    }
}
