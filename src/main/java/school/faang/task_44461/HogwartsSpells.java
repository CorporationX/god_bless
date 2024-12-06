package school.faang.task_44461;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.print(String.format("ID: %s, eventType: %s, actionDescription: %s",
                    entry.getValue().getId(), entry.getValue().getEventType(), entry.getValue().getAction()));
        }
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(),k -> new ArrayList<>()).add(spellEvent);
    }

    public String getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            return  null;
        }
        return spellById.get(id).toString();
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            return null;
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            System.out.println(String.format("Элемент с id=%d не найден в заклинаниях.", id));
            return;
        }
        spellById.remove(id);
        spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
    }
}


