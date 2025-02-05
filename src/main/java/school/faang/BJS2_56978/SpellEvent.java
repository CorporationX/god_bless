package school.faang.BJS2_56978;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class SpellEvent {
    private UUID id;
    private EvantType eventType;
    private final String action;

    public SpellEvent(EvantType eventType, String action) {
        this.eventType = eventType;
        this.action = action;
    }

    public UUID generatId() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid;
        return uuid;

    }
}
