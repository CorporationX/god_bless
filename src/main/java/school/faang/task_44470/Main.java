package school.faang.task_44470;

import java.util.List;

public class Main {
    public static final int WORK_ID = 3;
    public static final String WORK_STRING = "Заклинание";
    public static final String NOT_WORK_STRING = "Волшебство";

    private static final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    public static void main(String[] args) {
        hogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "Заклинание", "Наводит порчу");
        hogwartsSpells.addSpellEvent(4, "Заклинание", "Защищает от порчи");
        hogwartsSpells.addSpellEvent(5, "Заклинание", "Прибавляет сил");
        hogwartsSpells.printAllSpellEvents();
        checkGetByEventTypeFunction(WORK_STRING);
        checkGetByEventTypeFunction(NOT_WORK_STRING);
        checkGetByIdFunction(WORK_ID);
        System.out.println("Удаляем spellEvent с id = " + WORK_ID);
        hogwartsSpells.deleteSpellEvent(WORK_ID);
        checkGetByIdFunction(WORK_ID);
        checkGetByEventTypeFunction(WORK_STRING);
        hogwartsSpells.printAllSpellEvents();
    }

    public static void checkGetByIdFunction(int id) {
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(id);
        if (spellEvent != null) {
            System.out.println("Нашли spellEvent c id = " + id + ": " + spellEvent);
        } else {
            System.out.println("Не найден spellEvent с id = " + id);
        }
    }

    public static void checkGetByEventTypeFunction(String eventType) {
        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType(eventType);
        if ((spellEvents != null) && (!spellEvents.isEmpty())) {
            System.out.println("Найдены с типом заклинания '" + eventType + "':");
            spellEvents.forEach(System.out::println);
        } else {
            System.out.println("Не найдены spellEvent с типом заклинания: '" + eventType + "'");
        }
    }
}
