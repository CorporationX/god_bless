package school.faang.bjs244514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, (type) -> new ArrayList<>())
                .add(spellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.remove(spellEvent.getName());
        } else {
            System.out.println("Объект с номером " + id + " не найден в наших картах");
        }
    }

    public static void printAllSpellEventsById() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printAllSpellEventsByType() {
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addSpellEvent(1, "Protection", "Protection from attack");
        addSpellEvent(2, "Protection", "Protection from attack and magic");
        addSpellEvent(3, "Rise", "Lift into the air");
        addSpellEvent(4, "Transfiguration", "Transfiguration item");

        System.out.println(getSpellEventById(4));
        System.out.println(getSpellEventByType("Transfiguration"));
        deleteSpellEvent(5);
        printAllSpellEventsByType();
        printAllSpellEventsById();
    }
}
