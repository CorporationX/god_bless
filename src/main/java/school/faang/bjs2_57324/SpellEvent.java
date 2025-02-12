package school.faang.bjs2_57324;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {
    private static int counter = 0;
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = ++counter;
        this.eventType = eventType;
        this.action = action;
    }
}
