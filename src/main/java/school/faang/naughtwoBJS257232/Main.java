package school.faang.naughtwoBJS257232;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        createSpellEventMaps(hogwartsSpells);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------");

        Optional<SpellEvent> optionalSpellEvent = hogwartsSpells.getSpellEventById(1);
        if (optionalSpellEvent.isPresent()) {
            SpellEvent spellEvent = optionalSpellEvent.get();
            System.out.println(spellEvent.toString());
        }
        System.out.println("-----------------------------------");

        Optional<List<SpellEvent>> optionalSpellEventList = hogwartsSpells.getSpellEventsByType("Jinx");
        if (optionalSpellEventList.isPresent()) {
            List<SpellEvent> spellEventList = optionalSpellEventList.get();
            System.out.println(Arrays.toString(spellEventList.toArray()));
        }
        System.out.println("-----------------------------------");

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------");
    }

    private static void createSpellEventMaps(HogwartsSpells hogwartsSpells) {
        hogwartsSpells.addSpellEvent("Charm", "Conjures light");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms one object into another");
        hogwartsSpells.addSpellEvent("Protection", "Shields against dark magic");
        hogwartsSpells.addSpellEvent("Hex", "Causes minor discomfort or annoyance");
        hogwartsSpells.addSpellEvent("Jinx", "Creates a small hindrance or obstacle");
        hogwartsSpells.addSpellEvent("Charm", "Enhances abilities or objects");
        hogwartsSpells.addSpellEvent("Transfiguration", "Changes the appearance of an object");
        hogwartsSpells.addSpellEvent("Curse", "Inflicts serious harm or misfortune");
        hogwartsSpells.addSpellEvent("Hex", "Causes a change in physical state");
        hogwartsSpells.addSpellEvent("Charm", "Summons objects from a distance");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms a living creature into an object");
        hogwartsSpells.addSpellEvent("Protection", "Repels magical creatures");
        hogwartsSpells.addSpellEvent("Charm", "Manipulates emotions");
        hogwartsSpells.addSpellEvent("Jinx", "Causes clumsiness");
        hogwartsSpells.addSpellEvent("Curse", "Inflicts pain or suffering");
        hogwartsSpells.addSpellEvent("Spell", "Banishes evil creatures or spirits");
        hogwartsSpells.addSpellEvent("Charm", "Increases speed or agility");
        hogwartsSpells.addSpellEvent("Transfiguration", "Alters size or shape of an object");
        hogwartsSpells.addSpellEvent("Protection", "Prevents possession by dark entities");
        hogwartsSpells.addSpellEvent("Hex", "Restricts movement of the target");
    }

}
