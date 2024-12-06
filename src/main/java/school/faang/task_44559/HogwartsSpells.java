package school.faang.task_44559;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_44559.entity.SpellEvent;
import school.faang.task_44559.entity.SpellType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpells {
    private static final Logger log = LoggerFactory.getLogger(HogwartsSpells.class);
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellType, List<SpellEvent>> spellByType = new HashMap<>();

    /**
     * Adds a new spell event.
     *
     * @param spellEvent the SpellEvent object to be added.
     * @throws IllegalArgumentException if an event with the same ID already exists.
     */
    public void addSpellEvent(SpellEvent spellEvent) {
        if (spellById.containsKey(spellEvent.getId())) {
            throw new IllegalArgumentException("Event " + spellEvent.getId() + " already exists");
        }
        spellById.put(spellEvent.getId(), spellEvent);
        List<SpellEvent> spells = spellByType.computeIfAbsent(spellEvent.getType(), k -> new ArrayList<>());
        spells.add(spellEvent);
    }

    /**
     * Retrieves a spell event by its ID.
     *
     * @param id the ID of the spell event to retrieve.
     * @return the SpellEvent object associated with the given ID.
     * @throws IllegalArgumentException if no spell event with the specified ID exists.
     */
    public SpellEvent getSpellEventById(int id) throws IllegalArgumentException {
        SpellEvent spellEvent = spellById.get(id);
        return Optional.ofNullable(spellEvent)
                .orElseThrow(() -> new IllegalArgumentException("No such " + id + " spell event"));
    }

    /**
     * Retrieves all spell events of a specific type.
     *
     * @param eventType the type of spell events to retrieve.
     * @return a list of SpellEvent objects associated with the given type.
     * @throws IllegalArgumentException if no spell events of the specified type exist.
     */
    public List<SpellEvent> getSpellsByType(SpellType eventType) throws IllegalArgumentException {
        List<SpellEvent> spells = spellByType.get(eventType);
        if (spells == null) {
            throw new IllegalArgumentException("Can't get spells by type " + eventType);
        }
        return spells;
    }

    /**
     * Deletes a spell event by its ID.
     *
     * @param id the ID of the spell event to delete.
     * @throws IllegalArgumentException if no spell event with the specified ID exists.
     */
    public void deleteSpellEvent(int id) throws IllegalArgumentException {
        if (spellById.get(id) == null) {
            throw new IllegalArgumentException(id + " does not exist");
        }
        SpellEvent deletedSpell = spellById.remove(id);
        if (deletedSpell == null) {
            throw new IllegalArgumentException("Can't remove " + id + " spell event");
        }
        List<SpellEvent> spellsByDeletedSpellType = spellByType.get(deletedSpell.getType());
        spellsByDeletedSpellType.remove(deletedSpell);
        spellById.remove(id);
        log.info("Event {} has been deleted", id);
    }

    /**
     * Prints all stored spell events to the console.
     * Displays the ID, type, and description of each event.
     */
    public void printAllSpellEvents() {
        System.out.println("=== All Spell Events by ID ===");
        spellById.forEach((id, event) ->
                System.out.printf("ID: %d | Type: %s | Data: %s%n", id, event.getType(), event.getDescription())
        );
    }
}
