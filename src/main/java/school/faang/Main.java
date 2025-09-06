package school.faang;

import school.faang.BSJ2_85855.HogwartsSpells;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("eventType1", "actionDescription1");
        hogwartsSpells.addSpellEvent("eventType2", "actionDescription2");
        hogwartsSpells.addSpellEvent("eventType3", "actionDescription3");
        hogwartsSpells.addSpellEvent("eventType4", "actionDescription4");
        hogwartsSpells.addSpellEvent("eventType5", "actionDescription5");

        System.out.println(hogwartsSpells.getSpellEventById(Objects.hash("eventType3", "actionDescription3")));
        System.out.println(hogwartsSpells.getSpellEventById(Objects.hash("eventType6", "actionDescription6")));

        System.out.println("");

        System.out.println(hogwartsSpells.getSpellEventsByType("eventType5"));
        System.out.println(hogwartsSpells.getSpellEventsByType("eventType0"));

        System.out.println("");

        System.out.println(hogwartsSpells.deleteSpellEvent(Objects.hash("eventType10", "actionDescription10")));
        System.out.println(hogwartsSpells.deleteSpellEvent(Objects.hash("eventType1", "actionDescription1")));

        System.out.println("");

        hogwartsSpells.printAllSpellEvents();
    }
}
