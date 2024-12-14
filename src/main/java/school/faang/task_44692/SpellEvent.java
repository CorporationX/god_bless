package school.faang.task_44692;

public class SpellEvent {
    protected int id;
    protected String eventType;
    protected String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public String getEventType() {
        return this.eventType;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.eventType + " " + this.action;
    }

}
