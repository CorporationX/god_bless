package school.faang.task_44537;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Protection", "Creates a magical shield");
        hogwartsSpells.addSpellEvent(2, "Transfiguration", "Transforms an item");

        System.out.println(hogwartsSpells.getSpellEventById(1));

        List<SpellEvent> spells = hogwartsSpells.getSpellEventsByType("Transfiguration");
        spells.forEach(System.out::println);

        hogwartsSpells.deleteSpellEvent(2);

        System.out.println("\nAll spells:");
        hogwartsSpells.printAllSpellEvents();
    }
}