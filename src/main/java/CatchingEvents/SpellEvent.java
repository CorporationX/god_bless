package CatchingEvents;



public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String evntType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Заклинание: " +
                "номер = " + id +
                ", колдует = " + eventType + '\'' +
                ", получает = " + action + '\'';
    }
}
