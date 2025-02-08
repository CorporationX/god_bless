package school.faang.BJS2_57203;


import static school.faang.BJS2_57203.HogwartsSpells.printAllSpellEvents;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак");
        printAllSpellEvents();

        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет2");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет1");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак3");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак2");
        hogwartsSpells.addSpellEvent("магия", "Защищает от атак1");

        printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(1);
        printAllSpellEvents();

        hogwartsSpells.getSpellEventById(2);
        printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
    }
}
