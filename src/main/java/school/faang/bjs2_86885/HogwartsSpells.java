package school.faang.bjs2_86885;

import java.util.*;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellsById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private int count = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = count++;

        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellsById.put(id, spellEvent);
        List spellEventList = new ArrayList<>(List.of(spellEvent));
        spellsByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent getEventById = spellsById.get(id);
        return getEventById;
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        List<SpellEvent> getEventByTypeList = spellsByType.get(eventType);
        return getEventByTypeList;
    }

    public void deleteSpellEvent(int id) {
        spellsById.remove(id);
        spellsByType.remove(id);
    }

    public void printSpellEvent() {
        for (Map.Entry<Integer, SpellEvent> item : spellsById.entrySet()) {
            System.out.print(item + "" + item.getKey() + "" + item.getValue().eventType + "" + item.getValue().action);
        }
    }
}
