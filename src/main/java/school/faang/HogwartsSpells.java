package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int nextSpellId = spellById.size() + 1;
        SpellEvent spellEvent = new SpellEvent(nextSpellId, eventType, actionDescription);
        spellById.put(nextSpellId, spellEvent);

        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<SpellEvent>());
        }

        spellsByType.get(eventType).add(spellEvent);
        /*создает объект класса SpellEvent, автоматически генерирует уникальный ID, добавляет событие в обе HashMap;*/
    }

    public String getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            return null;
        }
        return spellById.get(id).getEventType();
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            return null;
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        String eventType = spellEvent.getEventType();

        spellsByType.get(eventType).remove(spellEvent);
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
