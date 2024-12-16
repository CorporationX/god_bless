package school.faang.task_44688;

import lombok.Getter;
import lombok.ToString;

@ToString
public class SpellEvent {
    private static int idCounter = 0;
    @Getter
    private final int id;
    @Getter
    private final String eventType;
    private final String actionDescription;

    public SpellEvent(String eventType, String action) {
        this.id = ++idCounter;
        this.eventType = eventType;
        this.actionDescription = action;
    }

    protected static void resetCounter() {
        idCounter = 0;
    }
}