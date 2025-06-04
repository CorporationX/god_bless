package school.faang.catcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final static Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private final static Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();
    private static int countId = 0;

    public static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(countId, eventType, actionDescription);
        SPELL_BY_ID.put(countId, spellEvent);
        SPELLS_BY_TYPE.computeIfAbsent(eventType, u -> new ArrayList<>()).add(spellEvent);
        countId++;
    }

    public static SpellEvent getSpellEventById(int id) {
        return SPELL_BY_ID.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return SPELLS_BY_TYPE.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SPELL_BY_ID.remove(id);
        for (var spellEntry : SPELLS_BY_TYPE.entrySet()) {
            List<SpellEvent> events = spellEntry.getValue();
            for (var spellEvent : events) {
                if (spellEvent.getId() == id) {
                    events.remove(spellEvent);
                }
            }
        }
    }

    public static void printAllSpellEvents() {
        for (var spellEntry : SPELL_BY_ID.entrySet()) {
            System.out.println(spellEntry.getValue());
        }
    }


}
