package school.faang.spells;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String action) {
        SpellEvent newEvent = new SpellEvent(eventType, action);
        spellById.put(newEvent.getSpellId(), newEvent);
        spellByType.putIfAbsent(eventType, new ArrayList<>());
        spellByType.get(eventType).add(newEvent);
    }

    public SpellEvent getSpellEventById(int id) throws NoSuchElementException  {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent == null) {
            throw new NoSuchElementException("Нет заклинания с id = %d".formatted(id));
        }

        return spellEvent;
    }

    public List<SpellEvent> getSpellEventByType(EventType eventType) throws NoSuchElementException {
        List<SpellEvent> spellEventList = spellByType.get(eventType);

        if (spellEventList == null) {
            throw new NoSuchElementException("Нет заклинаний с eventType = %s".formatted(eventType));
        }

        return spellEventList;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedFromById = spellById.remove(id);
        if (removedFromById == null) {
            throw new NoSuchElementException("События заклинания с id = %d не были добавлены в HashMap".formatted(id));
        }
        for (EventType key : spellByType.keySet()) {
            spellByType.get(key).removeIf(spellEvent -> spellEvent.getSpellId() == id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> eventEntry : spellById.entrySet()) {
            log.info("Заклинание с id = {}, тип = {} и эффектом = {}",
                    eventEntry.getKey(), eventEntry.getValue().getEventType(), eventEntry.getValue().getAction());
        }
    }
}
