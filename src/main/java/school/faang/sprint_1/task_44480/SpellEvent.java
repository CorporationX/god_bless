package school.faang.sprint_1.task_44480;

public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

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
        return "ID: " + id + ", Тип: " + eventType + ", Действие: " + action;
    }
}
