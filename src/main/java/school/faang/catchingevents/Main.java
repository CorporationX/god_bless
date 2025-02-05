package school.faang.catchingevents;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(EventType.ENCHANTMENT, "killing");
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "save our souls");
        hogwartsSpells.addSpellEvent(EventType.TRANSFIGURATION, "levitation");
        hogwartsSpells.addSpellEvent(EventType.TRANSFIGURATION, "lights on");

        hogwartsSpells.printAllSpellEvents();
        System.out.println("-".repeat(30));

        System.out.println(hogwartsSpells.getSpellEventById(3).getAction());
        System.out.println("-".repeat(30));

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellByType(EventType.TRANSFIGURATION);
        for (SpellEvent spellEvent : spellEvents) {
            System.out.println("=".repeat(30));
            System.out.println("ID: " + spellEvent.getId() +
                    "\nEvent type: " + spellEvent.getEventType() +
                    "\nAction: " + spellEvent.getAction());
        }
        System.out.println("-".repeat(30));

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-".repeat(30));
    }
}
