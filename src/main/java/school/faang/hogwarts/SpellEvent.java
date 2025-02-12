package school.faang.hogwarts;

import lombok.Data;

@Data
public class SpellEvent {
    private static int counter = 1;
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = counter++;
        this.eventType = eventType;
        this.action = action;
    }

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}


