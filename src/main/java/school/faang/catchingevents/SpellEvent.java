package school.faang.catchingevents;

import java.util.Random;
import java.util.Set;

public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setAction(String action) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("SpellEvent: ");
        sb.append("id= ").append(getId()).append(", ");
        sb.append("eventType= ").append(getEventType()).append(", ");
        sb.append("action= ").append(getAction());
        return sb.toString();
    }
}
