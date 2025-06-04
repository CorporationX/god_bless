package school.faang.catching_events;

import lombok.Data;

@Data
public class SpellEvent {
    private static int counter = 0;
    private final int ID;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.ID = ++counter;
        this.eventType = eventType;
        this.action = action;
    }
}
