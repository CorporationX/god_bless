package school.faang.bjs2_68810.catch_event;

import lombok.Getter;
import lombok.ToString;
import java.util.UUID;

@ToString
@Getter
public class SpellEvent {
    private final UUID id;
    private final EventType eventType;
    private final String action;

    public SpellEvent(EventType eventType, String action) {
        this.id = UUID.randomUUID();
        this.eventType = eventType;
        this.action = action;
    }
}
