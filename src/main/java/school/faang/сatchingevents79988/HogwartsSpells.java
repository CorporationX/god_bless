package school.faang.сatchingevents79988;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    public Map<Integer, SpellEvent> spellById = new HashMap<>();
    public Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    List<Integer> idList = new ArrayList<>(List.of(1));

    public void addSpellEvent(String eventType, String actionDescription) {
        int idSpell = idList.get(idList.size() - 1) + 1;
        idList.add(idSpell);
        SpellEvent spellEvent = new SpellEvent(idSpell, eventType, actionDescription);
        spellById.put(idSpell, spellEvent);

        List<SpellEvent> spellEventList = new ArrayList<>();

        if (spellsByType.get(eventType) != null) {
            spellEventList = spellsByType.get(eventType);
            spellEventList.add(spellEvent);
            spellsByType.put(eventType, spellEventList);
        } else {
            spellEventList.add(spellEvent);
            spellsByType.put(eventType, spellEventList);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);

        Map<String, List<SpellEvent>> doubleMap = spellsByType;
        List<SpellEvent> doubleList = new ArrayList<>();
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            List<SpellEvent> spellEventList = entry.getValue();
            for (SpellEvent spellEvent : spellEventList) {
                if (spellEvent.getId() != id) {
                    doubleList.add(spellEvent);
                }
            }
            doubleMap.put(entry.getKey(), doubleList);
        }
        spellsByType = doubleMap;
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("id:" + entry.getValue().getId() + " " + "Тип заклинания: " + entry.getValue().getEventType() + ". " + "Заклинание: " + entry.getValue().getAction());
        }
    }
}
