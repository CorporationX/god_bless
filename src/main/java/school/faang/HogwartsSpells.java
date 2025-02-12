package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    static Map<Integer, SpellEvent> spellById = new HashMap<>();
    static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int currentId = 1;

    public static void main(String[] args) {
        addSpellEvent("Skeleton Archer", "Struggle on your side");
        addSpellEvent("Fire Ball", "You throw fire from your hands");
        addSpellEvent("Freeze", "You make your enemies slowly");
        addSpellEvent("Poison", "Your enemies get damage over time");

        printAllSpellEvents();

    }

    public static void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event != null) {
            System.out.println("Found spell event: " + event);
        } else {
            System.out.println("Spell event for ID: " + id + " not found.");
        }
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }

    }

    public static void printAllSpellEvents() {
        for (SpellEvent event : spellById.values()) {
            System.out.println(event);
        }
    }

}



