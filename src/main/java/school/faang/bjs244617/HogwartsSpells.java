package school.faang.bjs244617;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellEvent.SpellType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, SpellEvent.SpellType type) {
        spellById.put(id, new SpellEvent(id, type));
        spellsByType.computeIfAbsent(type, k -> new ArrayList<>()).add(spellById.get(id));
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(SpellEvent.SpellType eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        if (Objects.isNull(event)) {
            return;
        }
        spellById.remove(id);
        Optional.ofNullable(spellsByType.get(event.getEventType()))
                .ifPresent(listOfEvents -> listOfEvents.remove(event));
    }

    public void printAllSpellEvents() {
        System.out.println(spellById.entrySet());
    }
}
