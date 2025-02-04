package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class SpellEvent {
    private UUID id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
    }

    public UUID generatId() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid;
        return uuid;

    }
}
