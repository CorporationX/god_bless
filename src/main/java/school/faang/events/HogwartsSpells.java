package school.faang.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class HogwartsSpells {

    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELL_BY_TYPE = new HashMap<>();
    private static Integer LAST_ID = 0;

    public static void addSpellEvent(String eventType, String actionDescription) {
        var id = LAST_ID++;
        var event = new SpellEvent(id, eventType, actionDescription);
        SPELL_BY_ID.put(id, event);
        SPELL_BY_TYPE.putIfAbsent(eventType, new ArrayList<>());
        SPELL_BY_TYPE.get(eventType).add(event);
    }

    public static SpellEvent getSpellEventById(int id) {
        return SPELL_BY_ID.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String type) {
        return SPELL_BY_TYPE.get(type);
    }

    public static void deleteSpellEvent(Integer id) {
        var event = SPELL_BY_ID.remove(id);
        SPELL_BY_TYPE.get(event.eventType()).remove(event);
    }

    public static void printAllSpellEvents() {
        for (var entry : SPELL_BY_ID.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
