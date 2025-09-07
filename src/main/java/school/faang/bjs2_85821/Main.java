package school.faang.bjs2_85821;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Защита", "Щит");
        spells.addSpellEvent("Защита", "Барьер");
        spells.addSpellEvent("Атака", "Огненный шар");

        List<SpellEvent> protectionSpells = spells.getSpellEventsByType("Защита");
        System.out.println("Защитных заклинаний: " + protectionSpells.size()); // 2

        spells.printAllSpellEvents();
    }
}
