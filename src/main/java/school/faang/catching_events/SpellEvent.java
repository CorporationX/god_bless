package school.faang.catching_events;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private final Integer id;
    private final String eventType;
    private final String action;

    protected SpellEvent(Integer id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
