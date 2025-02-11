package school.faang.task_57162;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELL_BY_TYPE = new HashMap<>();
    private static final String MESSAGE_OF_ADD = "ADDING: %s has been added.\n";
    private static final String MESSAGE_OF_DELETE = "DELETING: %s has been deleted.\n";
    private static final String NOT_FOUND_MESSAGE = "DELETING: spell event was not found by %d id.\n";

    public static void addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        SPELL_BY_ID.put(spellEvent.getId(), spellEvent);
        SPELL_BY_TYPE.computeIfAbsent(spellEvent.getEventType(), k -> new ArrayList<>())
                .add(spellEvent);
        System.out.printf(MESSAGE_OF_ADD, spellEvent);
    }

    public static SpellEvent getSpellById(@NonNull Integer id) {
        return SPELL_BY_ID.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(@NonNull String evenType) {
        return SPELL_BY_TYPE.get(evenType);
    }

    public static void deleteSpellEvent(@NonNull Integer id) {
        if (SPELL_BY_ID.containsKey(id)) {
            SpellEvent spellEvent = SPELL_BY_ID.get(id);
            String eventTypeKey = spellEvent.getEventType();
            SPELL_BY_ID.remove(id);

            List<SpellEvent> spellEvents = SPELL_BY_TYPE.get(eventTypeKey);
            spellEvents.remove(spellEvent);
            if (spellEvents.isEmpty()) {
                SPELL_BY_TYPE.remove(eventTypeKey);
            } else {
                SPELL_BY_TYPE.replace(eventTypeKey, spellEvents);
            }
            System.out.printf(MESSAGE_OF_DELETE, spellEvent);
        } else {
            System.out.printf(NOT_FOUND_MESSAGE, id);
        }
    }

    public static void printAllSpellEvents() {
        SPELL_BY_ID.forEach((spellEventId, spellEvent) -> System.out.println(spellEvent));
    }
}
