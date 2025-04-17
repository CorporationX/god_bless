package school.faang.sprintone.catchevent;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Чар", "Защищает от атак");
        spells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        spells.addSpellEvent("Защита", "Создает магический щит");
        spells.addSpellEvent("Чар", "Увеличивает скорость");

        System.out.println("Все заклинания после добавления:");
        spells.printAllSpellEvents();

        System.out.println("\nПолучение заклинания с ID = 2:");
        SpellEvent spellEvent = spells.getSpellEventById(2);
        if (spellEvent != null) {
            System.out.println(spellEvent);
        } else {
            System.out.println("Заклинание с таким ID не найдено.");
        }

        System.out.println("\nЗаклинания типа 'Чар':");
        List<SpellEvent> spellsByType = spells.getSpellEventsByType("Чар");
        for (SpellEvent spell : spellsByType) {
            System.out.println(spell);
        }

        System.out.println("\nУдаление заклинания с ID = 1.");
        spells.deleteSpellEvent(1);

        System.out.println("\nВсе заклинания после удаления:");
        spells.printAllSpellEvents();
    }
}