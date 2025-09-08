package school.faang.bjs2_85872;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
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
