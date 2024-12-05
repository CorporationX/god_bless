package school.faang.task_44407;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Лечение", "Восстанавливает здоровье");
        hogwartsSpells.addSpellEvent(2, "Лечение", "Очищает от ядов");
        hogwartsSpells.addSpellEvent(3, "Лечение", "Лечит раны");
        hogwartsSpells.addSpellEvent(4, "Атака", "Огненная стрела");
        hogwartsSpells.addSpellEvent(5, "Атака", "Ледяной удар");
        hogwartsSpells.addSpellEvent(6, "Атака", "Молния");
        hogwartsSpells.addSpellEvent(7, "Бафф", "Увеличивает силу");
        hogwartsSpells.addSpellEvent(8, "Бафф", "Увеличивает скорость");
        hogwartsSpells.addSpellEvent(9, "Бафф", "Увеличивает защиту");

        System.out.println("\n" + hogwartsSpells.getSpellEventById(1));

        hogwartsSpells.deleteSpellEvent(1);

        List<SpellEvent> healingSpells = hogwartsSpells.getSpellEventByType("Лечение");
        System.out.println("\nЗаклинания типа 'Лечение':");
        for (SpellEvent spellEvent : healingSpells) {
            System.out.println(spellEvent);
        }

        System.out.println();
        hogwartsSpells.printAllSpellEvents();
    }
}
