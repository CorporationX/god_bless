package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Чар", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Изменяет форму объекта");
        hogwartsSpells.addSpellEvent("Чар", "Лечит раны");

        System.out.println("Все события заклинаний:");
        hogwartsSpells.printAllSpellEvents();

        SpellEvent spell = hogwartsSpells.getSpellEventById(2);
        System.out.println("\nСобытие с ID 2: " + spell);

        List<SpellEvent> charSpells = hogwartsSpells.getSpellEventsByType("Чар");
        System.out.println("\nСобытия 'Чар':");
        for (SpellEvent charSpell : charSpells) {
            System.out.println(charSpell);
        }

        hogwartsSpells.deleteSpellEvent(2);
        System.out.println("\nПосле удаления события с ID 2:");
        hogwartsSpells.printAllSpellEvents();
    }
}