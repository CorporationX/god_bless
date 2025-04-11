package school.faang.spells;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class SpellEvent {
    private final int spellId;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        spellId = IdGenerator.id.getAndIncrement();
    }

}
