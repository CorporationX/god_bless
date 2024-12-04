package school.faang.task_44414;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent spellEvent) {
        if (spellEvent == null) {
            throw new NullPointerException("Spell event cannot be null");
        }
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.putIfAbsent(spellEvent.getSpellType(), new ArrayList<>());
        spellsByType.get(spellEvent.getSpellType()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(SpellType spellType) {
        return spellsByType.get(spellType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event == null) {
            throw new NoSuchElementException("There is no event under: " + id);
        }
        List<SpellEvent> spellEvents = getSpellEventsByType(event.getSpellType());
        spellEvents.remove(event);
    }

    public void printAllSpellEvents() {
        System.out.println("SPELLS BY ID:");
        spellById.forEach((id, spellEvent) -> System.out.println(id + " : " + spellEvent));

        System.out.println("SPELLS BY TYPE:");
        spellsByType.forEach((id, spells) -> System.out.println(id + " : " + spells));
    }
}