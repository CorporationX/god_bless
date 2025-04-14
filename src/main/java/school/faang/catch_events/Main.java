package school.faang.catch_events;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();

        hogwarts.addSpellEvent("Огонь и пламя", "Выпустить огненный шар");
        hogwarts.addSpellEvent("Огонь и пламя", "Вызвать огненный дождь");
        hogwarts.addSpellEvent("Лечение", "Восстановить здоровье");
        hogwarts.addSpellEvent("Телепортация", "Переместить предмет");
        hogwarts.addSpellEvent("Защита", "Выставить лазерный щит перед собой");

        hogwarts.printAllSpellEvents();

        log.info("\nСобытие с ID 2:");
        SpellEvent event = hogwarts.getSpellEventById(2);
        log.info(event.getAction());

        log.info("\nВсе активированные Защитные заклинания:");
        hogwarts.getSpellEventsByType("Защита").forEach(e ->
                log.info(e.getAction()));

        log.info("\nУдаляем событие с ID 3 и 5:");
        hogwarts.deleteSpellEvent(3);
        hogwarts.deleteSpellEvent(5);
        hogwarts.printAllSpellEvents();

        log.info("\nПопытка удаления события с отрицательным ID");
        try {
            hogwarts.deleteSpellEvent(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Обнаружено исключение: " + e.getMessage());
        }
    }
}
