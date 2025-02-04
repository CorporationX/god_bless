package school.faang.catchingevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static final Set<String> POSSIBLE_EVENTS = Set.of("Чар", "Трансфигурация", "Защита");

    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        if (POSSIBLE_EVENTS.contains(eventType)) {
            this.eventType = eventType;
        } else {
            throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
        this.action = action;
    }
}
