package school.faang.bjs2_85831.spell;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    private static int counter;

    public SpellEvent(String eventType, String action) {
        SpellEventValidator.validateSpellEvent(eventType, action);
        this.id = ++counter;
        this.eventType = eventType;
        this.action = action;
    }
}
