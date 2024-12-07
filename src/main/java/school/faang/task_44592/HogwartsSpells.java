package school.faang.task_44592;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        try {
            var spellEvent = new SpellEvent(id, eventType, actionDescription);

            spellById.put(id, spellEvent);

            spellsByType.putIfAbsent(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
        } catch (IllegalArgumentException ex) {
            System.out.println("Заклинание не может быть добавлено: " + ex.getMessage());
            throw ex;
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        var spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.entrySet().removeIf(entry -> {
                    entry.getValue().remove(spellEvent);
                    return entry.getValue().isEmpty();
                }
            );
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
