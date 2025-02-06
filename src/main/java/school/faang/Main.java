package school.faang;

import school.BJS57042.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("attack", "create fireball");
        hogwartsSpells.addSpellEvent("defense", "create shield");
        hogwartsSpells.addSpellEvent("defense", "create guard near you");
        hogwartsSpells.addSpellEvent("show", "show enemies position ");
        hogwartsSpells.addSpellEvent("attack", "create ice arrow");

        hogwartsSpells.getSpellEventById(2);
        hogwartsSpells.getSpellEventById(4);
        hogwartsSpells.getSpellEventById(15);

        hogwartsSpells.getSpellEventsByType("attack");
        hogwartsSpells.getSpellEventsByType("show");
        hogwartsSpells.getSpellEventsByType("defense");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(4);

        hogwartsSpells.printAllSpellEvents();
    }
}
