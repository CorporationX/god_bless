package school.faang.bjs2_86888;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SpellEvent {

    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}