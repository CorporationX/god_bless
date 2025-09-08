package school.faang.bjs2_85864;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class SpellEvent {
    private static int idCounter = 0; // для генерации уникального ID
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = ++idCounter;
        this.eventType = eventType;
        this.action = action;
    }
}