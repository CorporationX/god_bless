package school.faang.events.catching;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        System.out.println("\nПроверяем добавление");
        hogwartsSpells.addSpellEvent("Чары", "Проворотное заклинание");
        hogwartsSpells.addSpellEvent("Чары", "Отворотное заклинание");
        hogwartsSpells.addSpellEvent("Чары", "Оборотное заклинание");
        hogwartsSpells.addSpellEvent("Зелья", "Проворотное зелье");
        hogwartsSpells.addSpellEvent("Зелья", "Оборотное зелье");
        hogwartsSpells.addSpellEvent("Транфигурация", "Анимагия");
        System.out.println("\nПроверяем поиск по Id");
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println("\nПроверяем поиск по типу заклинания");
        List<SpellEvent> list = hogwartsSpells.getSpellEventsByType("Зелья");
        list.forEach(System.out::println);
        System.out.println("\nПроверяем удаление");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.deleteSpellEvent(20);
        System.out.println("\nПроверяем печать заклинаний");
        hogwartsSpells.printAllSpellEvents();
    }
}
