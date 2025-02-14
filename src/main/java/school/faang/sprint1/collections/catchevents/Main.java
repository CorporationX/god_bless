package school.faang.sprint1.collections.catchevents;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventIdException;
import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventTypeException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Левитирует предмет");
        hogwartsSpells.addSpellEvent("Чары", "Осветляет кончик палочки");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует объект в животное");
        hogwartsSpells.addSpellEvent("Защита", "Создаёт магический барьер");

        System.out.println("Список заклинаний:");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("Получение заклинания по ID = 1:");
        try {
            System.out.println(hogwartsSpells.getSpellEventById(1));
        } catch (NotFoundSpellEventIdException e) {
            log.warn(e.getMessage());
        }
        System.out.println();

        System.out.println("Заклинания типа 'Чары':");
        try {
            System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));
        } catch (IllegalArgumentException e) {
            log.warn(e.getMessage());
        }
        System.out.println();

        System.out.println("Удаление заклинания с ID = 2");
        try {
            hogwartsSpells.deleteSpellEvent(2);
        } catch (NotFoundSpellEventTypeException | NotFoundSpellEventIdException e) {
            log.warn(e.getMessage());
        }
        System.out.println();

        System.out.println("Список заклинаний после удаления:");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("Попытка получить несуществующее заклинание:");
        try {
            System.out.println(hogwartsSpells.getSpellEventById(99));
        } catch (NotFoundSpellEventIdException e) {
            log.warn(e.getMessage());
        }
        System.out.println();

        System.out.println("Попытка получить заклинания несуществующего типа:");
        try {
            System.out.println(hogwartsSpells.getSpellEventsByType("Люмос"));
        } catch (IllegalArgumentException e) {
            log.warn(e.getMessage());
        }
    }
}
