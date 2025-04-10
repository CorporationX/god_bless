package school.faang.bjs2_68712;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
    private static int counter = 0;

    public SpellEvent(String eventType, String action) {
        this.id = ++counter;
        if (eventType == null) {
            log.error("EventType cannot be null. Please provide a valid EventType instance to initialize the SpellEvent.");
            throw new IllegalArgumentException("EventType cannot be null. A valid EventType instance is required.");
        }
        this.eventType = eventType;
        if (action == null || action.trim().isEmpty()) {
            log.error("Action cannot be null or empty. Please provide a valid action string to initialize the SpellEvent.");
            throw new IllegalArgumentException("Action cannot be null or empty. A valid action string is required.");
        }
        this.action = action;
    }
}
