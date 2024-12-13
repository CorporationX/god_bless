package school.faang.moduleone.sprintone.task_43513;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HogwartsSpells {
    private static HogwartsSpells hogwartsSpells;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private HogwartsSpells() {
    }

    public static HogwartsSpells getHogwartsSpells() {
        if (hogwartsSpells == null) {
            hogwartsSpells = new HogwartsSpells();
        }
        return hogwartsSpells;
    }

    public void addSpellEvent(SpellEvent spellEvent) {
        if (spellEvent != null) {
            addSpellEvent(spellEvent.id(), spellEvent.eventType(), spellEvent.action());
        }
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        if (Objects.isNull(spellById.putIfAbsent(id, spellEvent))) {
            spellsByType.putIfAbsent(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (!Objects.isNull(spellEvent)) {
            spellById.remove(id);
            spellsByType.get(spellEvent.eventType()).remove(spellEvent);
        }
        return spellEvent;
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
