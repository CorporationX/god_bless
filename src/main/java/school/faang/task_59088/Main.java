package school.faang.task_59088;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, SpellEvent> spellById = new HashMap<>();
        Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Defense", "Cast Protego to block an attack");
        hogwartsSpells.addSpellEvent(2, "Attack", "Cast Expelliarmus to disarm opponent");
        hogwartsSpells.addSpellEvent(3, "Attack", "Cast Avada Kedavra to kill opponent");

        System.out.println("All spellEvents");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("getSpellEventById(2)");
        SpellEvent spellEventById = hogwartsSpells.getSpellEventById(2);
        System.out.println(spellEventById.toString());
        System.out.println();

        System.out.println("getSpellEventsByType(\"Defense\")");
        List<SpellEvent> defenseSpells = hogwartsSpells.getSpellEventsByType("Defense");
        for (SpellEvent spell : defenseSpells) {
            System.out.println(spell.toString());
        }
        System.out.println();

        System.out.println("deleteSpellEvent(1)");
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println("getSpellEventsByType(\"Attack\")");
        List<SpellEvent> utilitySpells = hogwartsSpells.getSpellEventsByType("Attack");
        for (SpellEvent spell : utilitySpells) {
            System.out.println(spell.toString());
        }
    }
}
