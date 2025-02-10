package school.faang;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SpellEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", action='" + action + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SpellEvent that = (SpellEvent) o;
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }


}
