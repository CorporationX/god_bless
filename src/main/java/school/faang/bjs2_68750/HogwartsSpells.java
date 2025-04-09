package school.faang.bjs2_68750;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(), k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) throws Exception {
        return Optional.ofNullable(spellById.get(id))
                .orElseThrow(() -> new Exception(String.format("Spell by id = %d not found", id)));
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) throws Exception {
        spellsByType.remove(getSpellEventById(id).getEventType());
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((key, value) -> System.out.printf("Id = %s  Spell description: %s  \n", key, value));
    }
}
