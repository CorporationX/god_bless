package school.faang.bjs2_79787;

import lombok.Data;

@Data
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
    private static int objectCount = 0;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
        objectCount++;
    }

    public static int getCurrentSpellCount() {
        return objectCount;
    }

    @Override
    public String toString() {
        return String.format("id: %d, event type: %s, action: %s", id, eventType, action);
    }
}
