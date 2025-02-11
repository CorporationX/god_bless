package school.faang.task_57162;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Defense", "Protects from fire");
        HogwartsSpells.addSpellEvent("Defense", "Protects from cold");
        HogwartsSpells.addSpellEvent("Attack", "Deals fire damage");
        HogwartsSpells.addSpellEvent("Attack", "Deals cold damage");
        HogwartsSpells.addSpellEvent("Attack", "Deals electric damage");

        SpellEvent electricSpellEvent = HogwartsSpells.getSpellById(5);
        System.out.println(electricSpellEvent);
        List<SpellEvent> defenseSpellEvents = HogwartsSpells.getSpellEventsByType("Defense");
        System.out.printf("Defensive spells: %s\n", defenseSpellEvents);

        HogwartsSpells.deleteSpellEvent(5);
        HogwartsSpells.deleteSpellEvent(5);

        HogwartsSpells.printAllSpellEvents();
    }
}
