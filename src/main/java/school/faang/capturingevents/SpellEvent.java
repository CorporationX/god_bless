package school.faang.capturingevents;

import java.util.Objects;

public class SpellEvent {

    private Integer id;
    private String eventType;
    private String action;

    public SpellEvent(Integer id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return Objects.equals(id, that.id)
                && Objects.equals(eventType, that.eventType)
                && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }

    @Override
    public String toString() {
        return String.format("SpellEvent{id=%d, eventType='%s', action='%s'}", id, eventType, action);
    }

}
