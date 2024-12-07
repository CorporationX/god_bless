package school.faang.bjs244591;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, SpellType eventType, String actionDescription) {
        if (eventType.toString().isEmpty() || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("Enter truly information");
        }
        SpellEvent spellEvents = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvents);
        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvents);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new RuntimeException("Key is not found !");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(SpellType eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new RuntimeException("Key is not found !");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event == null) {
            throw new RuntimeException("There is no event under: " + id);
        }
        List<SpellEvent> spellEvents = getSpellEventsByType(event.eventType());
        spellEvents.remove(event);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> {
            System.out.println(id + " - " + spellEvent.eventType() + " : " + spellEvent.action());
        });
    }
}
