package school.faang.catchevents;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private int spellId = 0;

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        int spellId = generateSpellId();
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);
        this.spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
        this.spellById.put(spellId, spellEvent);
        return spellEvent;
    }

    public SpellEvent getSpellEventById(int id) {
        return Optional.ofNullable(this.spellById.get(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Spell with id %d doesn't exist", id)));
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return Optional.ofNullable(this.spellsByType.get(eventType))
                .orElseThrow(() -> new NoSuchElementException(String.format("EventType %s doesn't exist", eventType)));
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent removedSpellEvent = this.spellById.remove(id);
        if (removedSpellEvent != null) {
            this.spellsByType.get(removedSpellEvent.getEventType()).remove(removedSpellEvent);
        }
        return removedSpellEvent != null;
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEventEntry : this.spellById.entrySet()) {
            SpellEvent spellEvent = spellEventEntry.getValue();
            log.info("Spell id = [{}], type = [{}], action = [{}]", spellEventEntry.getKey(), spellEvent.getEventType(),
                    spellEvent.getAction());
        }
    }

    private int generateSpellId() {
        return spellId++;
    }
}