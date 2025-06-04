package school.faang.bjs2_79675;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> magicsById = new HashMap<>();
    private final Map<String, List<SpellEvent>> typeMagics = new HashMap<>();
    private int currentId;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        magicsById.put(id, spellEvent);

        typeMagics.putIfAbsent(eventType, new ArrayList<>());
        typeMagics.get(eventType).add(spellEvent);

    }

    public SpellEvent getSpellEventById(int id) {
        return magicsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return typeMagics.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = magicsById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = typeMagics.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : magicsById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Event: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Defense", "Creates a magical shield");
        spells.addSpellEvent("Transfiguration", "Transforms objects");
        spells.addSpellEvent("Charm", "Makes objects levitate");

        System.out.println("\n All spell events:");
        spells.printAllSpellEvents();

        System.out.println("\n Searching for spell event by ID (1):");
        System.out.println(spells.getSpellEventById(1));

        System.out.println("\n Searching for spell events by type 'Defense':");
        for (SpellEvent event : spells.getSpellEventsByType("Defense")) {
            System.out.println(event);
        }

        System.out.println("\n Deleting spell event with ID 1");
        spells.deleteSpellEvent(1);

        System.out.println("\n Spell events after deletion:");
        spells.printAllSpellEvents();
    }

}
