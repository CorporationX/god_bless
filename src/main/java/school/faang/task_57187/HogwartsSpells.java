package school.faang.task_57187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int idCounter = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = idCounter++;

        SpellEvent newSpell = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, newSpell);
        spellsByType.computeIfAbsent(newSpell.getEventType(), spellType -> new ArrayList<>()).add(newSpell);
        System.out.println("Добавлено заклинание: " + id + " " + newSpell.getEventType());
    }


    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> events = spellsByType.get(eventType);
        if (events != null && !events.isEmpty()) {
            System.out.printf("Найдены события по типу %s\n\n", eventType);
        } else {
            System.out.printf("Не найдены события по типу %s\n\n", eventType);
        }
        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        if (event != null) {
            spellsByType.get(event.getEventType()).remove(event);
            System.out.println("Удалено событие под номером " + id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("\nID события: %s\n\tID заклинания: %s\n\tТип заклинания: %s\n\t" +
                            "Действие заклинания: %s\n",
                    entry.getKey(), entry.getValue().getId(), entry.getValue().getEventType(),
                    entry.getValue().getAction());
        }
    }
}
