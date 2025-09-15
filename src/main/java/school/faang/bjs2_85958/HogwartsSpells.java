package school.faang.bjs2_85958;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {

        if (eventType == null || actionDescription == null) {
            throw new IllegalArgumentException("Тип и действие не могут быть null");
        }

        SpellEvent event = new SpellEvent(eventType, actionDescription);
        int id = event.getId();
        spellById.put(id, event);

        List<SpellEvent> list = spellsByType.get(eventType);
        if (list == null) {
            list = new ArrayList<>();
            spellsByType.put(eventType, list);
        }

        list.add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            System.out.println("Такого id нет");
        }
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> list = spellsByType.get(eventType);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent removedEvent = spellById.remove(id);
        if (removedEvent == null) {
            return false;
        }
        List<SpellEvent> list = spellsByType.get(removedEvent.getEventType());
        if (list != null) {
            list.remove(removedEvent);
            if (list.isEmpty()) {
                spellsByType.remove(removedEvent.getEventType());
            }
        }
        return true;
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            Integer key = entry.getKey();
            SpellEvent value = entry.getValue();
            System.out.println("ID: " + key
                    + ", Тип: " + value.getEventType()
                    + ", Действие: " + value.getAction());
        }
    }
}
