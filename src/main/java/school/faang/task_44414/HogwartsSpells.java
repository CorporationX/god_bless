package school.faang.task_44414;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> spellEvents = getSpellEventsByType(event.getEventType());
            spellEvents.remove(event);
        } else {
            throw new NoSuchElementException("Такого события не существует");
        }
    }

    public void printAllSpellEvents() {
        System.out.println("SPELLS BY ID:");
        spellById.forEach((id, spellEvent) -> System.out.println(id + " : " + spellEvent));

        System.out.println("SPELLS BY TYPE:");
        spellsByType.forEach((id, spells) -> System.out.println(id + " : " + spells));

        System.out.println("===============================");
    }
}