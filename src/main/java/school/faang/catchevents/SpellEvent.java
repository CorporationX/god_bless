package school.faang.catchevents;

import java.util.Objects;

public class SpellEvent {
    private static int UNIQUE_ID = 1;
    private int id;
    private String eventType;
    private String action;

    public static int getUniqueId() {
        return UNIQUE_ID;
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

    public SpellEvent(String eventType, String action) {
        this.id = UNIQUE_ID++;
        this.eventType = eventType;
        this.action = action;
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
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }

    @Override
    public String toString() {
        return String.format("id = %d, event type = %s, action = %s ", id, eventType, action);
    }
}
