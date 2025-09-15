package school.faang.bjs2_85958;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static int nextId = 1;
    private final int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = nextId++;
        this.eventType = eventType;
        this.action = action;
    }
}
