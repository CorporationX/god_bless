package school.faang.catchingevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static int currentId = 100;

    private final int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }
}
