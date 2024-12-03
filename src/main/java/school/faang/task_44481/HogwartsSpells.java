package school.faang.task_44481;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final static Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEventToAdd = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEventToAdd);

        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEventToAdd);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEventToDelete = getSpellEventById(id);
        spellById.remove(id);

        String spellEventToDeleteEventType = spellEventToDelete.getEventType();
        spellByType.get(spellEventToDeleteEventType).remove(spellEventToDelete);
    }

    public static void printAllSpellEvents() {
        System.out.println("Printing all spell events...");
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
        System.out.println("End of printing all spell events.");
    }

}
