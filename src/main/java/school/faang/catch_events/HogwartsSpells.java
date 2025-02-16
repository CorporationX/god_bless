package school.faang.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private static final String[] eventTypes = {"Magic", "Transform", "Protect"};
    private static final String[] actionDescriptions = {"Gives magic affect",
            "Transform any object", "Protect from attack"};

    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellsByType;
    private int currentId = 1;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {

        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {

        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {

        var spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            var listSpellsEvent = spellsByType.get(spellEvent.getEventType());
            if (listSpellsEvent != null) {
                listSpellsEvent.remove(spellEvent); /* Вопрос: почему, если я не определил метод equals в SpellEvent,
                                                    / то метод remove все равно удаляет его?*/
            }
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((k, v) -> {
            System.out.println(v.getId() + ". " + v.getEventType() + ", " + v.getAction());
        });
    }

    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(eventTypes[0], actionDescriptions[0]);
        hogwartsSpells.addSpellEvent(eventTypes[1], actionDescriptions[1]);
        hogwartsSpells.addSpellEvent(eventTypes[2], actionDescriptions[2]);

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(2));
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
        // Вопрос: почему, если я не определил метод equals в SpellEvent, то метод remove все равно удаляет его?
    }
}
