package school.faang.bjs2_85988;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private static int spellId = 0;
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void deleteSpellEvent(int id) {
        final SpellEvent spellEvent = spellById.remove(id);

        if (spellEvent != null) {
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }

    @SneakyThrows
    public int addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        spellId++;

        spellById.put(spellId, new SpellEvent(spellId, eventType, actionDescription));

        spellsByType.computeIfAbsent(
                spellById.get(spellId).getEventType(),
                key -> new ArrayList<>()).add(spellById.get(spellId));

        return spellId;
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.get(id) == null) {
            throw new NullPointerException("Spell by id %d not found".formatted(id));
        }

        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }
}