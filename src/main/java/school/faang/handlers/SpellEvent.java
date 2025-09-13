package school.faang.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private static int currentId = 1;

    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        if (eventType == null || action == null) {
            throw new IllegalArgumentException("eventType и action не могут быть null");
        }

        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }
}