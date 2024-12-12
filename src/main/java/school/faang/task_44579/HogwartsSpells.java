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
        if (!spellById.containsKey(id)) {
            System.out.printf("Заклинание с ID: %d не найдено в базе.%n", id);
            return;
        }

        SpellEvent spellEvent = spellById.remove(id);
        System.out.printf("Заклинание с ID: %d успешно удалено из базы.%n", id);

        if (Objects.nonNull(spellEvent)) {
            outPutNonNullSpellEvent(id, spellEvent);
        } else {
            System.out.printf("Событие заклинания не найдено по ID: %d%n", id);
        }
    }

    private void outPutNonNullSpellEvent(int id, SpellEvent spellEvent) {
        String eventType = spellEvent.getEventType();
        List<SpellEvent> events = spellsByType.get(eventType);

        if (events == null || events.isEmpty()) {
            System.out.printf("Список заклинаний для типа '%s' отсутствует или уже пуст.%n", eventType);
            return;
        }

        events.remove(spellEvent);
        System.out.printf("Заклинание с ID: %d удалено из списка событий типа: %s%n", id, eventType);

        if (events.isEmpty()) {
            spellsByType.remove(eventType);
            System.out.printf("Тип '%s' удален.%n", eventType);
        } else {
            System.out.printf("Список типа '%s' обновлен. Осталось %d заклинаний.%n", eventType, events.size());
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
