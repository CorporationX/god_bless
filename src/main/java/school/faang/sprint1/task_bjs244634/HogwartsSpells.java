package school.faang.sprint1.task_bjs244634;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellsById;
    // Карта для хранения списка событий заклинаний по их типу.
    // Ключ - String (тип события), значение - List<SpellEvent>
    private Map<String, List<SpellEvent>> spellsByType;

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        // добавляет новое событие заклинания в обе карты;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellsById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        // возвращает событие заклинания по его ID;
    }

    public void getSpellEventsByType(String eventType) {
        // возвращает список событий заклинаний по типу;
    }

    public void deleteSpellEvent(int id) {
        // удаляет событие заклинания по его ID из обеих карт;
    }

    public void printAllSpellEvents() {
        // Выводит информацию о всех событиях заклинаний в консоль,
        // используя обход массива Entry в карте spellById. Выведите ID, тип и данные каждого события.
    }

}
