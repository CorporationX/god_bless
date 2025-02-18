package CatchingEvents;

import lombok.Getter;

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

    @Override
    public String toString() {
        return "Заклинание: " +
                "номер = " + id +
                ", колдует = " + eventType + '\'' +
                ", получает = " + action + '\'';
    }
}
