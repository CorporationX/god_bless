package school.faang.sprint.first.catchevent;

import school.faang.sprint.first.catchevent.service.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.addSpellEvent("Spell", "Avada");
        hogwartsSpells.addSpellEvent("Shield", "Avada Kedavra");
        System.out.println("Спелл: " + hogwartsSpells.getSpellEventById(0));
        hogwartsSpells.addSpellEvent("Shield", "Manus");
        System.out.println("Спелл: " + hogwartsSpells.getSpellEventsByType("Shield"));
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
