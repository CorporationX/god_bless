package school.faang.task_44470;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String ACTION_DESCRIPTION_STRING = "Наводит порчу";
    public static final String WORK_STRING = "Заклинание";
    public static final String NOT_WORK_STRING = "Волшебство";

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        Map<String, Integer> eventIds = new HashMap<>();
        addEvent(hogwartsSpells, eventIds,"Чар", "Защищает от атак");
        addEvent(hogwartsSpells, eventIds,"Трансфигурация", "Преобразует предмет");
        addEvent(hogwartsSpells, eventIds,"Заклинание", "Наводит порчу");
        addEvent(hogwartsSpells, eventIds,"Заклинание", "Защищает от порчи");
        addEvent(hogwartsSpells, eventIds,"Заклинание", "Прибавляет сил");
        hogwartsSpells.printAllSpellEvents();
        checkGetByEventTypeFunction(hogwartsSpells, WORK_STRING);
        checkGetByEventTypeFunction(hogwartsSpells, NOT_WORK_STRING);
        checkGetByIdFunction(hogwartsSpells, eventIds, ACTION_DESCRIPTION_STRING);
        deleteEvent(hogwartsSpells, eventIds, ACTION_DESCRIPTION_STRING);
        checkGetByEventTypeFunction(hogwartsSpells, WORK_STRING);
        hogwartsSpells.printAllSpellEvents();
    }

    public static void addEvent(HogwartsSpells hogwartsSpells, Map<String, Integer> eventIds,
                                String eventType, String actionDescription) {
        Integer id = hogwartsSpells.addSpellEvent(eventType, actionDescription);
        eventIds.put(actionDescription, id);
    }

    public static void deleteEvent(HogwartsSpells hogwartsSpells, Map<String, Integer> eventIds,
                                   String actionDescription) {
        System.out.println("Удаляем spellEvent с описанием '" + actionDescription + "'");
        Integer id = eventIds.get(actionDescription);
        if (id != null) {
            if (hogwartsSpells.deleteSpellEvent(id)) {
                System.out.println("spellEvent с id = " + id + " и описанием '" + actionDescription + "' удалено.");
            } else {
                System.out.println("spellEvent с id = " + id + " и описанием '"
                        + actionDescription + "' не найдено.");
            }
            eventIds.remove(actionDescription);
        } else {
            System.out.println("Не найден id spellEvent с описанием: '" + actionDescription + "'");
        }
    }

    public static void checkGetByIdFunction(HogwartsSpells hogwartsSpells, Map<String, Integer> eventIds,
                                            String actionDescription) {
        Integer id = eventIds.get(actionDescription);
        if (id != null) {
            SpellEvent spellEvent = hogwartsSpells.getSpellEventById(id);
            if (spellEvent != null) {
                System.out.println("Нашли spellEvent c id = " + id + ": " + spellEvent);
            } else {
                System.out.println("Не найден spellEvent с id = " + id);
            }
        } else {
            System.out.println("Не найден event id для '" + actionDescription + "'");
        }
    }

    public static void checkGetByEventTypeFunction(HogwartsSpells hogwartsSpells, String eventType) {
        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType(eventType);
        if ((spellEvents != null) && (!spellEvents.isEmpty())) {
            System.out.println("Найдены с типом заклинания '" + eventType + "':");
            spellEvents.forEach(System.out::println);
        } else {
            System.out.println("Не найдены spellEvent с типом заклинания: '" + eventType + "'");
        }
    }
}
