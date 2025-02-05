package school.faang.catch_the_event;

import lombok.Data;

@Data
public class SpellEvent {

    private int id;
    private String eventType;
    private String action;
    private static int currentId = 1;

    public SpellEvent(String eventType, String action) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым или null");
        }
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Действие заклинания не может быть пустым или null");
        }

        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }
}
