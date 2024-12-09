package school.faang.task_44573;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();

    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent spellEvent) {
        addSpellInSpellById(spellEvent);
        addSpellInSpellsByType(spellEvent);
    }

    private void addSpellInSpellsByType(SpellEvent spellEvent) {
        spellsByType.computeIfAbsent(spellEvent.getEventType(), key -> new ArrayList<>())
                .add(spellEvent);
    }

    private void addSpellInSpellById(SpellEvent spellEvent) {
        int id = spellEvent.getId();
        spellById.put(id, spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String spellType) {
        return spellsByType.get(spellType);
    }

    public void deleteSpellEvent(int id) {
        deleteFromSpellById(id);
        deleteFromSpellsByType(id);
    }

    private void deleteFromSpellsByType(int id) {
        spellsByType.forEach((key, value) ->
                spellsByType.computeIfPresent(key, (k, spellList) -> {
                    spellList.removeIf(spell -> spell.getId() == id);
                    return spellList.isEmpty() ? new ArrayList<>() : spellList;
                })
        );
    }

    private void deleteFromSpellById(int id) {
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((key, value) -> {
            System.out.println("ID :: " + key
                    + " | Type :: " + value.getEventType()
                    + " | Description :: " + value.getEventDescription());
        });
    }

    public void printingOutTheSpellsByTypeMap() {
        System.out.println(" ");
        spellsByType.forEach((key, value) -> {
            System.out.println(key + " :: " + value);
        });
    }

}
