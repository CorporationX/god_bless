package school.faang.hogwarts.spell.management;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private static Integer idCounter = 0;

    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = idCounter++;
        this.eventType = eventType;
        this.action = action;
    }
}
