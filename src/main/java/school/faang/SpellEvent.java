package school.faang;

public class SpellEvent {
    private int currentId = 1;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        int id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
