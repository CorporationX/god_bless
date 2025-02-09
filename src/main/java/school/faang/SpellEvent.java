package school.faang;

import lombok.Data;

@Data
public class SpellEvent {
    private static int counter = 1;
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String evenType, String action) {
        this.id = counter++;
        this.eventType = evenType;
        this.action = action;
    }

    public SpellEvent(int id, String evenType, String action) {
        this.id = id;
        this.eventType = evenType;
        this.action = action;
    }
}


