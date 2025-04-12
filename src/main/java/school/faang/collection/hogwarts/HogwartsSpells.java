package school.faang.collection.hogwarts;

import lombok.extern.slf4j.Slf4j;
import school.faang.collection.hogwarts.spell.SpellEvent;
import school.faang.collection.hogwarts.spell.SpellType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
public class HogwartsSpells {

    private static final Map<Integer, SpellEvent> spellsById = new HashMap<>();
    private static final Map<SpellType, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(SpellType spellType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(spellType, actionDescription);
        spellsById.put(newEvent.getId(), newEvent);
        spellsByType.computeIfAbsent(spellType, type -> new ArrayList<>()).add(newEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellsById.get(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("No spell event with id - %d".formatted(id));
        }
        return spellEvent;
    }

    public static List<SpellEvent> getSpellEventsByType(SpellType spellType) throws NoSuchElementException {
        List<SpellEvent> spellEvents = spellsByType.get(spellType);
        if (spellEvents == null) {
            throw new NoSuchElementException("No spell events with type - %s".formatted(spellType));
        }
        return spellEvents;
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent eventToDelete = getSpellEventById(id);
        spellsById.remove(id);
        getSpellEventsByType(eventToDelete.getSpellType()).remove(eventToDelete);
    }

    public static void printAllEvents() {
        spellsById.forEach((key, value) -> log.info("{} - {}", key, value));
    }
}