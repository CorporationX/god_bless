package school.faang.task_44579;

import java.util.*;


public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        // Попытка удалить заклинание из spellById
        SpellEvent spellEvent = spellById.remove(id);

        if (Objects.nonNull(spellEvent)) {
            // Заклинание найдено в spellById, начинаем удаление из spellsByType
            System.out.printf("Заклинание с ID: %d найдено. Тип: %s, описание: %s%n",
                    spellEvent.getId(), spellEvent.getEventType(), spellEvent.getAction());

            String eventType = spellEvent.getEventType();
            List<SpellEvent> events = spellsByType.get(eventType);

            if (events != null) {
                // Удаляем событие из списка событий данного типа
                events.remove(spellEvent);
                System.out.printf("Заклинание с ID: %d удалено из списка событий типа: %s%n", id, eventType);

                // Если список событий типа пуст, удаляем сам тип из карты
                if (events.isEmpty()) {
                    spellsByType.remove(eventType);
                    System.out.printf("Тип события '%s' удален, так как больше не содержит заклинаний.%n", eventType);
                } else {
                    System.out.printf("Список событий типа '%s' обновлен. Осталось %d заклинаний.%n", eventType, events.size());
                }
            } else {
                // На случай, если список событий для типа заклинания отсутствует (дополнительная защита)
                System.out.printf("Не удалось найти список событий для типа: %s. Возможно, это ошибка.%n", eventType);
            }
        } else {
            // Заклинание с указанным ID не найдено
            System.out.printf("Событие заклинания не найдено по ID: %d%n", id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEventEntry : spellById.entrySet()) {
            Integer spellId = spellEventEntry.getKey();
            SpellEvent spellEvent = spellEventEntry.getValue();
            System.out.printf("Заклинание Id: %s, тип: %s, описание: %s%n",
                    spellId,
                    spellEvent.getEventType(),
                    spellEvent.getAction());
        }
    }
}
