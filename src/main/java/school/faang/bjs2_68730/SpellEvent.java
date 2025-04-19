package school.faang.bjs2_68730;

import lombok.Getter;
import lombok.ToString;

@ToString
class SpellEvent {
    @Getter
    private final Integer id;
    @Getter
    private final EventType eventType;
    private final String action;

    public SpellEvent(Integer id, EventType eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
