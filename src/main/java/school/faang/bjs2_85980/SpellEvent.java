package school.faang.bjs2_85980;

import java.util.Objects;

public record SpellEvent(int id, String eventType, String action) {

    public SpellEvent {
        Objects.requireNonNull(eventType, "Event type cannot be null");
        Objects.requireNonNull(action, "Action cannot be null");
    }
}