package school.faang.sprint_1.task_44599;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            HogwartsSpells hogwartsSpells = new HogwartsSpells();
            hogwartsSpells.addSpellEvent(1, "Трансфигурация", "Перемещает");
            hogwartsSpells.addSpellEvent(2, "Защита", "Защищает от атак");
            hogwartsSpells.addSpellEvent(3, "Чар", "Преобразует предмет");
            hogwartsSpells.addSpellEvent(4, "Защита", "Защищает от атак");

            System.out.println(hogwartsSpells.getSpellEventById(1));

            System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));

            hogwartsSpells.printAllSpellEvents();

            hogwartsSpells.deleteSpellEvent(4);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}