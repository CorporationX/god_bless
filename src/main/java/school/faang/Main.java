package school.faang;


import static school.faang.HogwartsSpells.printAllSpellEvents;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак");
        printAllSpellEvents();

        System.out.println("---------------------------");

        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет2");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет1");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак3");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак2");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак1");

        printAllSpellEvents();

        System.out.println("---------------------------");
        hogwartsSpells.deleteSpellEvent(1);
        printAllSpellEvents();

        System.out.println("---------------------------");
        hogwartsSpells.getSpellEventById(2);
        printAllSpellEvents();

        System.out.println("---------------------------");
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
    }
}
