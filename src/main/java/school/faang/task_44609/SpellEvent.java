package school.faang.task_44609;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpellEvent {

    private int id;

    private String eventType;

    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return String.format("SpellEvent{id=%d, eventType='%s', action='%s'}", id, eventType, action);
    }
}
