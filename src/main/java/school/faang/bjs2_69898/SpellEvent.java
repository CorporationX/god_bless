package school.faang.bjs2_69898;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SpellEvent {
    private UUID id;
    private EventType eventType;
    private String action;

    public SpellEvent(EventType eventType, String action) {
        this.id = UUID.randomUUID();
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return "SpellEvent: " + "id = " + id +
                ", eventType = " + eventType +
                ", action = '" + action;
    }
}