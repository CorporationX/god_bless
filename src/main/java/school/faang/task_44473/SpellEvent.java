package school.faang.task_44473;

public class SpellEvent {
    private Integer id;
    private EventType eventType;
    private String action;

    public SpellEvent(Integer id, EventType eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "SpellEvent{"
                + "id=" + id
                + ", eventType=" + eventType
                + ", action='" + action + '\''
                + '}';
    }
}
