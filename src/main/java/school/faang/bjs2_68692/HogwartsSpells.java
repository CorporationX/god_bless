package school.faang.bjs2_68692;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class HogwartsSpells {
    private final Map<UUID, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public UUID addSpellEvent(EventType eventType, String actionDescription) {
        UUID uuid = UUID.randomUUID();
        var spellEvent = new SpellEvent(uuid, eventType, actionDescription);
        spellById.put(uuid, spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
        return uuid;
    }

    public SpellEvent getSpellEventById(UUID id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(UUID id) {
        spellById.entrySet().stream().filter(entry -> entry.getKey().equals(id))
                .map(entry -> entry.getValue().eventType()).forEachOrdered(spellsByType::remove);
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }
}
