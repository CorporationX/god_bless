package school.faang.sprint1.task_44545;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "type2", "action1");
        System.out.println(
            hogwartsSpells.getSpellEventById(1)
        );
        hogwartsSpells.addSpellEvent(2, "type2", "action2");
        System.out.println(
                hogwartsSpells.getSpellEventsByType("type2")
        );
        hogwartsSpells.printAllSpellEvents();
    }
}
