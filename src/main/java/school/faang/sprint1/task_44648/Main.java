package school.faang.sprint1.task_44648;

import java.util.NoSuchElementException;

import static school.faang.sprint1.task_44648.SpellEvent.CHARM_TYPE;
import static school.faang.sprint1.task_44648.SpellEvent.PROTECTION_TYPE;
import static school.faang.sprint1.task_44648.SpellEvent.TRANSFIGURATION_TYPE;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        System.out.println("\nAdding one spell event of type " + CHARM_TYPE);
        hogwartsSpells.addSpellEvent(1, CHARM_TYPE, "This charm is bad!");
        System.out.println("\nPrinting all spell events of type " + CHARM_TYPE);
        hogwartsSpells.getSpellEventsByType(CHARM_TYPE).forEach(System.out::println);
        System.out.println("\nDeleting all spell events...");
        hogwartsSpells.deleteSpellEvent(1);
        System.out.println("\nPrinting all spell events after deletion");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nAdding two more spell events of type " + CHARM_TYPE);
        hogwartsSpells.addSpellEvent(1, CHARM_TYPE, "This charm is bad!");
        hogwartsSpells.addSpellEvent(2, CHARM_TYPE, "This charm is good!");
        System.out.println("\nPrinting all spell events of type " + CHARM_TYPE);
        hogwartsSpells.getSpellEventsByType(CHARM_TYPE).forEach(System.out::println);

        System.out.println("\nVerify exception for non-existent id...");
        try {
            hogwartsSpells.getSpellEventById(100);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }

        System.out.println("\nVerify querying by unused type...");
        try {
            hogwartsSpells.getSpellEventsByType(TRANSFIGURATION_TYPE);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }

        System.out.println("\nAdding two more spell events of type "
                + TRANSFIGURATION_TYPE + " and  " + PROTECTION_TYPE);
        hogwartsSpells.addSpellEvent(3, TRANSFIGURATION_TYPE, "This transfiguration is good!");
        hogwartsSpells.addSpellEvent(4, PROTECTION_TYPE, "This protection is good!");
        System.out.println("\nPrinting all spell events ");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nVerify adding unknown event type...");
        try {
            hogwartsSpells.addSpellEvent(1, "Unknown type", "This charm is bad!");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nVerify adding already existent event...");
        try {
            hogwartsSpells.addSpellEvent(5, PROTECTION_TYPE, "This protection is good!");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nVerify adding event with already existent id...");
        try {
            hogwartsSpells.addSpellEvent(4, TRANSFIGURATION_TYPE, "Completely new transfiguration!");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nVerify deleting event with non-existent id...");
        try {
            hogwartsSpells.deleteSpellEvent(2000);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
