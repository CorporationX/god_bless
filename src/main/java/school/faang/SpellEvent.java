package school.faang;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {
    private static int idCounter = 1;

    private final int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = idCounter++;
        this.eventType = eventType;
        this.action = action;
    }
}