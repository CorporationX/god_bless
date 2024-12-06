package school.faang.task_44573;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    public HashMap<Integer, SpellEvent> spellById = new HashMap<>();

    public HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent spellEvent) {
        addSpellInSpellById(spellEvent);
        addSpellInSpellsByType(spellEvent);
    }

    private void addSpellInSpellsByType(SpellEvent spellEvent) {
        String event = spellEvent.getEventType();
        List<SpellEvent> tempListWithSpellByType = spellsByType.get(event);

        if (tempListWithSpellByType == null) {
            tempListWithSpellByType = new ArrayList<>();
        }

        tempListWithSpellByType.add(spellEvent);
        spellsByType.put(event, tempListWithSpellByType);

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
        spellsByType.forEach((key, value) -> {
            List<SpellEvent> spellEvent = value;
            for (SpellEvent item : spellEvent) {
                if (item.getId() == id) {
                    spellEvent.remove(item);
                    break;
                }
            }
        });
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
}
