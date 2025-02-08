package school.faang.catching_events.BJS2_57034;

import lombok.NonNull;

public record SpellEvent(int id, String eventType, String action) {
    public SpellEvent(int id, @NonNull String eventType, @NonNull String action) {
        if (eventType.isBlank()) {
            throw new IllegalArgumentException("eventType cannot be blank");
        }
        if (action.isBlank()) {
            throw new IllegalArgumentException("action cannot be blank");
        }

        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
