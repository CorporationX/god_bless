package school.faang.bjs2_85997;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объект системы заклинаний
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        // Добавляем несколько заклинаний
        hogwartsSpells.addSpellEvent("Атака", "Волшебный огонь");
        hogwartsSpells.addSpellEvent("Защита", "Огненный щит");
        hogwartsSpells.addSpellEvent("Защита", "Земляной щит");
        hogwartsSpells.addSpellEvent("Телепортация", "Быстрая телепортация");
        hogwartsSpells.addSpellEvent("Исцеление", "Лечение ран");

        // Печать всех заклинаний
        System.out.println("Все заклинания:");
        hogwartsSpells.printAllSpellEvents();

        // Получаем заклинание по ID
        String someId = hogwartsSpells.getSpellById().keySet().iterator().next(); // берем первый попавшийся ID
        SpellEvent spell = hogwartsSpells.getSpellEventById(someId);
        System.out.println("\nПолученное заклинание по ID: ");
        System.out.println(spell);

        // Получаем заклинания по типу
        String spellByTypePrint = "Защита";
        System.out.println("\nЗаклинания типа " + "\"" + spellByTypePrint + "\":");
        List<SpellEvent> spellsByType = hogwartsSpells.getSpellsByType(spellByTypePrint);
        spellsByType.forEach(System.out::println);

        // Удаляем заклинание
        hogwartsSpells.deleteSpellEvent(someId);
        System.out.println("\nПосле удаления заклинания:");
        hogwartsSpells.printAllSpellEvents();
    }
}
