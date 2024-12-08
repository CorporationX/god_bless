package school.module1.task44498;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
