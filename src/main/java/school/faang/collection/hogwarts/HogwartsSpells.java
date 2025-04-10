package school.faang.collection.hogwarts;

import lombok.extern.slf4j.Slf4j;
import school.faang.collection.hogwarts.spell.SpellEvent;
import school.faang.collection.hogwarts.spell.SpellType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {

    private static final Map<Integer, SpellEvent> spellsById = new HashMap<>();
    private static final Map<SpellType, List<SpellEvent>> spellsByType = new HashMap<>();
    private static final String ID_NOT_FOUND_MESSAGE = "Заклинание c id {} - не найдено!";


    public static void addSpellEvent(SpellType spellType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(spellType, actionDescription);
        spellsById.put(newEvent.getId(), newEvent);
        spellsByType.computeIfAbsent(spellType, type -> new ArrayList<>()).add(newEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        if (spellsById.containsKey(id)) {
            return spellsById.get(id);
        }
        log.info(ID_NOT_FOUND_MESSAGE, id);
        return null;
    }

    public static List<SpellEvent> getSpellEventsByType(SpellType spellType) {
        if (spellsByType.containsKey(spellType)) {
            return spellsByType.get(spellType);
        }
        log.info("Заклинания типа {} - не найдены!", spellType);
        return new ArrayList<>();
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent eventToDelete = getSpellEventById(id);
        if (eventToDelete != null) {
            spellsById.remove(id);
            spellsByType.get(eventToDelete.getSpellType()).remove(eventToDelete);
            if (spellsByType.get(eventToDelete.getSpellType()).isEmpty()) {
                spellsByType.remove(eventToDelete.getSpellType());
            }
        }
    }

    public static void printAllEvents() {
        spellsById.forEach((key, value) -> log.info("{} - {}", key, value));
    }
}
