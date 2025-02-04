package school.faang.catchevents;

import lombok.Getter;

@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("SpellEvent{id=%d, eventType=%s, action=%s}", id, eventType, action);
    }
}
