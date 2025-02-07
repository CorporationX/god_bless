package school.faang.events;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        try {
            hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
            hogwartsSpells.addSpellEvent("Чары", "Заколдовывает врага - 1");
            hogwartsSpells.addSpellEvent("Чары", "Заколдовывает врага - 2");
            hogwartsSpells.addSpellEvent("Чары", "Заколдовывает врага - 3");
            hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
            hogwartsSpells.addSpellEvent("Защита", "Призывает силы природы");

            System.out.println(hogwartsSpells.deleteSpellEvent(3));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }

        System.out.println(hogwartsSpells.getSpellEventById(5));
        System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));

        System.out.println(hogwartsSpells.printAllSpellEvents());
    }
}