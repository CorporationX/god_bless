package school.faang.bjs2_57010;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
    private static int count = 1;

    public SpellEvent(String eventType, String action) {
        this.id = count++;
        this.eventType = eventType;
        this.action = action;
    }

}
