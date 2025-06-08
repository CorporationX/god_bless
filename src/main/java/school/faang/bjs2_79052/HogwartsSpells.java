package school.faang.bjs2_79052;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellByld = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int idCounter = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int newId = idCounter;
        idCounter++;
        SpellEvent spellEvent = new SpellEvent(newId, eventType, actionDescription);
        spellByld.put(newId, spellEvent);

        List<SpellEvent> spellList = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellList.add(spellEvent);
        spellsByType.put(eventType, spellList);
    }

    public SpellEvent getSpellEventByld(int id) {
        if (!spellByld.containsKey(id)) {
            throw new IllegalArgumentException("Неправильный номер");
        }
        return spellByld.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        if (!spellByld.containsKey(id)) {
            System.out.println("Такого номера нет");
            return;
        }

        SpellEvent deletedSpell = spellByld.remove(id);
        String eventType = deletedSpell.getEventType();
        List<SpellEvent> spellList = spellsByType.get(eventType);

        if (spellList != null) {
            spellList.remove(deletedSpell);

            if (spellList.isEmpty()) {
                spellsByType.remove(eventType);
            }
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Список: ");
        for (Map.Entry<Integer, SpellEvent> entry : spellByld.entrySet()) {
            System.out.println(entry.getKey() + " " + (entry.getValue()).getEventType() + " " +
                    (entry.getValue().getAction()));
        }
    }
}
