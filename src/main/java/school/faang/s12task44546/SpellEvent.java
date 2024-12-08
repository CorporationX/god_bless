package school.faang.s12task44546;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String actionDescription;

    public SpellEvent(int id, String eventType, String actionDescription) {
        this.id = id;
        this.eventType = eventType;
        this.actionDescription = actionDescription;
    }
}