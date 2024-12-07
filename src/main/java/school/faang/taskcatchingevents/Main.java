package school.faang.taskcatchingevents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Трансформация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Создает защитный барьер");
        hogwartsSpells.addSpellEvent(4, "Чар", "Увеличивает силу");

        System.out.println("Все заклинания: ");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(2);
        System.out.println("Заклинание с ID 2: " + spellEvent);
        System.out.println();

        List<SpellEvent> charmEvents = hogwartsSpells.getSpellEventsByType("Чар");
        System.out.println("Заклинание типа 'Чар' : ");
        for (SpellEvent event : charmEvents) {
            System.out.println(event);
        }
        System.out.println();

        hogwartsSpells.deleteSpellEvent(1);
        System.out.println("После удаления заклинания с ID 1: ");
        hogwartsSpells.printAllSpellEvents();
    }
}
