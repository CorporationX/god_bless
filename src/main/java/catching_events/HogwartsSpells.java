package catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>())
                .add(new SpellEvent(id, eventType, actionDescription));
        spellById.put(id, new SpellEvent(id, eventType, actionDescription));

        checkInsert(id, eventType);
        System.out.println("Событие добавлено");
    }

    public void getSpellEventById(int id) {
        validatorId(id);

        System.out.println("Тип события: " + spellById.get(id).getEventTypes()
                + " Описание: " + spellById.get(id).getAction());
    }

    public void getSpellEventsByType(String eventType) {
        validatorStringKey(eventType);
        System.out.println(spellsByType.get(eventType));
    }

    public void deleteSpellEvent(int id) {
        validatorId(id);
        SpellEvent delete = spellById.get(id);
        List<SpellEvent> eventList = spellsByType.get(delete.getEventTypes());

        eventList.remove(delete);
        spellById.remove(id);

        checkRemove(id, delete, eventList);
        System.out.println("событие удалено");

    }

    public void printAllSpellEvents() {
        validatorIsEmpty(spellById);

        spellById.entrySet().forEach(entry -> {
            System.out.println("int id = " + entry.getKey());
            System.out.println("String eventTypes = " + entry.getValue().getEventTypes());
            System.out.println("String action = " + entry.getValue().getAction());
        });
    }

    private void validatorIsEmpty(Map<Integer, SpellEvent> map) {
        if (spellById.isEmpty()) {
            throw new IllegalStateException("Нет ни одного события!");
        }
    }

    private void validatorId(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("нет события с id: " + id);
        }
    }

    private void validatorStringKey(String key) {
        if (!spellsByType.containsKey(key)) {
            throw new IllegalArgumentException("нет события: " + key);
        }
    }

    private void checkInsert(int id, String eventType) {
        if (!spellById.containsKey(id) && !spellsByType.containsKey(eventType)) {
            throw new IllegalStateException("Ошибка: данные не сохранились в карте!");
        }
    }

    private void checkRemove(int id, SpellEvent delete, List<SpellEvent> eventList) {
        if (spellById.containsKey(id)) {
            throw new IllegalStateException("Ошибка: данные не удалились из карты!");
        }
        if (eventList.contains(delete)) {
            throw new IllegalStateException("Данные не удалились!");
        }
    }
}