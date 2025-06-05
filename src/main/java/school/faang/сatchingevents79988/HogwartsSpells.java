package school.faang.сatchingevents79988;

import lombok.Getter;

import java.util.*;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();

    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private int countId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {

        int id = ++countId;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spellEventList = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellEventList.add(spellEvent);
        spellsByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            System.out.println("Нет заклинания с Id: " + id);
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            System.out.println("Отсутствует cписок заклинаний по типу " + eventType);
        }
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellRemoved = spellById.remove(id);
        if (spellRemoved == null) {
            System.out.println("Заклинания с таким id нет");
            return;
        }

        List<SpellEvent> list = spellsByType.get(spellRemoved.getEventType());
        list.remove(spellRemoved);
        if (list.isEmpty()) {
            spellsByType.remove(spellRemoved.getEventType());
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
