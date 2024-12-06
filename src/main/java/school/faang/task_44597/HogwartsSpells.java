package school.faang.task_44597;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent addToSpellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put((spellById.size() + 1), addToSpellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(addToSpellEvent);
    }

    public void getSpellEventById(int id) {
        if (spellById.get(id) != null) {
            System.out.println(spellById.get(id) + "\n");
        } else {
            System.out.printf("Заклинания с id: %d не найдено!!!\n\n", id);
        }

    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.get(eventType) != null) {
            System.out.println(spellsByType.get(eventType) + "\n");
        } else {
            System.out.printf("Заклинаний с типом: %s не найдено!!!\n\n", eventType);
        }

    }

    public void deleteSpellEvent(int id) {
        if (id > spellById.size()) {
            System.out.printf("Заклинание с id: %d не найдено!!!\n\n", id);
        } else {
            SpellEvent spellEventToDelete = spellById.remove(id);
            if (spellEventToDelete != null) {
                List<SpellEvent> listSpellEventToDelete = spellsByType.get(spellEventToDelete.getEventType());
                if (listSpellEventToDelete != null) {
                    listSpellEventToDelete.remove(spellEventToDelete);
                    System.out.printf("Успешно удалено заклинание с id: %d!!!\n\n", spellEventToDelete.getId());
                    if (listSpellEventToDelete.isEmpty()) {
                        spellsByType.remove(spellEventToDelete.getEventType());
                    }
                }
            }
        }

    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> pair : spellById.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
        System.out.println();

        for (Map.Entry<String, List<SpellEvent>> pair : spellsByType.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
        System.out.println();
    }
}
