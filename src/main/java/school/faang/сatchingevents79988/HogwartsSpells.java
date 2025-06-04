package school.faang.сatchingevents79988;

import lombok.Getter;

import java.util.*;

public class HogwartsSpells {
    @Getter
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    @Getter
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    int countId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {

        int id = ++countId;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spellEventList = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellEventList.add(spellEvent);
        spellsByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellRemoved = spellById.remove(id);
        if (spellRemoved == null) {
            System.out.println("Заклинания с таким id нет");
            return;
        }

        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            List<SpellEvent> spellEventList = entry.getValue();
            spellEventList.remove(spellRemoved);
            spellsByType.put(entry.getKey(), spellEventList);
        }
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            if (entry.getValue().isEmpty()) {
                spellsByType.remove(entry.getKey());
            }
        }

    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            String result = String.format("id: %d Тип заклинания: %s.  Заклинание: %s.",
                    entry.getValue().getId(), entry.getValue().getEventType(), entry.getValue().getAction());
            System.out.println(result);
        }
    }
}
