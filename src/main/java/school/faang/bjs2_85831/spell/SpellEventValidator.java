package school.faang.bjs2_85831.spell;

import school.faang.bjs2_85831.exception.EventTypeNotAllowedException;
import school.faang.bjs2_85831.exception.SpellEventValidationException;

import java.util.Set;

public class SpellEventValidator {
    private static final Set<String> eventTypes = Set.of("разрушение", "трансфигурация", "защита", "чары");

    private SpellEventValidator() {

    }

    static void validateSpellEvent(String eventType, String action) {
        if (eventType == null || action == null) {
            throw new SpellEventValidationException("тип заклинания и его описание не могут быть null");
        }
        validateSpellEventType(eventType);
    }

    static void validateSpellEventType(String eventType) {
        if (!eventTypes.contains(eventType.toLowerCase())) {
            throw new EventTypeNotAllowedException("заклинание такого типа недопустимо\n" +
                    "набор допустимых заклинаний: " + eventTypes);
        }
    }
}
