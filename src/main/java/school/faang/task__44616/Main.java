package school.faang.task__44616;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        // добавляем инфо для демонстрации функционала
        hogwartsSpells.addSpellEvent(1, "Чар", "зеленый чай");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "трансформер");
        hogwartsSpells.addSpellEvent(3, "Защита", "блок");

        System.out.println("--- All Spell Events ---");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n--- Find Spell Event by ID ---");
        SpellEvent foundSpell = hogwartsSpells.getSpellEventById(1);
        System.out.println("Found: " + foundSpell);

        System.out.println("\n--- Find Spell Events by Type ---");
        List<SpellEvent> defenseSpells = hogwartsSpells.getSpellEventsByType("Защита");
        defenseSpells.forEach(spell -> System.out.println(spell));


        System.out.println("\n--- Delete Spell Event by ID ---");
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
