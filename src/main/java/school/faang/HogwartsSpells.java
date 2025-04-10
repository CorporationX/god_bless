package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Long, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private long idCounter;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(idCounter, eventType, actionDescription);
        incrementId();
        spellById.put(idCounter, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(long id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(long id) {
        spellById.remove(id);
        spellsByType.values().forEach(events -> events.removeIf(event -> event.id() == id));
    }

    public void printAllSpellEvents() {
        spellsByType.values()
                .forEach(events ->
                        events.forEach(event -> System.out.println(event.id()
                                                                   + " " + event.eventType()
                                                                   + " " + event.action())));
    }

    private void incrementId() {
        idCounter++;
    }
}
