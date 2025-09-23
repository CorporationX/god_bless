package school.faang.sprint1.catchevent;

import java.util.NoSuchElementException;

public class HogwartsSpellsTest {

    private final HogwartsSpellsImpl hogwartsSpells = new HogwartsSpellsImpl();

    public static void main(String[] args) {
        HogwartsSpellsTest tester = new HogwartsSpellsTest();

        tester.testAddSpellEvent();
        tester.testGetSpellEventById();
        tester.testGetSpellEventById_nonExistentId();
        tester.testGetSpellEventsByType();
        tester.testGetSpellEventsByType_emptyList();
        tester.testDeleteSpellEvent();
        tester.testDeleteSpellEvent_nonExistentSpell();
        tester.testPrintAllSpellEvents();
    }

    private void testPrintAllSpellEvents() {
        System.out.println("-------------------------------------");
        System.out.println("Printing all stored in system spell events:");
        System.out.println("-------------------------------------");

        hogwartsSpells.printAllSpellEvents();
    }

    private void testDeleteSpellEvent_nonExistentSpell() {
        System.out.println("-------------------------------------");
        System.out.println("Deleting spell event by non existent ID:");
        System.out.println("-------------------------------------");

        int id = 200;
        System.out.println("Response should be FALSE: " + hogwartsSpells.deleteSpellEvent(id));
    }

    private void testDeleteSpellEvent() {
        System.out.println("-------------------------------------");
        System.out.println("Deleting spell event by existing ID:");
        System.out.println("-------------------------------------");

        int id = 2;
        SpellEvent spell = hogwartsSpells.getSpellEventById(id);

        System.out.println("Response should be TRUE: " + hogwartsSpells.deleteSpellEvent(id));
        System.out.println("Storage Map 'SpellById' does not contain ID = " + id + ": "
            + !hogwartsSpells.getSpellById().containsKey(id));
        System.out.println("Storage Map 'SpellsByType' does not contain spell with ID = " + id + ": "
            + hogwartsSpells.getSpellsByType().get(spell.getEventType()).stream()
            .noneMatch((s) -> s.getId() == id));
    }

    private void testGetSpellEventsByType() {
        System.out.println("-------------------------------------");
        System.out.println("Getting List of spell events by existing type:");
        System.out.println("-------------------------------------");

        String type = "Charm";
        System.out.println("Should have Type = " + type);
        System.out.println(hogwartsSpells.getSpellEventsByType(type));
    }

    private void testGetSpellEventsByType_emptyList() {
        System.out.println("-------------------------------------");
        System.out.println("Getting List of spell events by not recorded type:");
        System.out.println("-------------------------------------");

        String type = "Curse";
        System.out.println("Should be empty list");
        System.out.println(hogwartsSpells.getSpellEventsByType(type));
    }

    private void testGetSpellEventById() {
        System.out.println("-------------------------------------");
        System.out.println("Getting spell event by existing ID:");
        System.out.println("-------------------------------------");

        int id = 2;
        System.out.println("Should have ID = " + id);
        System.out.println(hogwartsSpells.getSpellEventById(id));
    }

    private void testGetSpellEventById_nonExistentId() {
        System.out.println("-------------------------------------");
        System.out.println("Getting spell event by not valid ID:");
        System.out.println("-------------------------------------");

        int id = 200;
        System.out.println("Should print WARN message:");
        try {
            System.out.println(hogwartsSpells.getSpellEventById(id));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testAddSpellEvent() {
        System.out.println("-------------------------------------");
        System.out.println("Adding new Spell Event");
        System.out.println("-------------------------------------");

        SpellEvent s1 = hogwartsSpells.addSpellEvent("Charm", "Description for Charm spell 1");
        SpellEvent s2 = hogwartsSpells.addSpellEvent("Transfiguration", "Description for Transfiguration spell 1");
        SpellEvent s3 = hogwartsSpells.addSpellEvent("Defense", "Description for Defense spell 1");
        SpellEvent s4 = hogwartsSpells.addSpellEvent("Charm", "Description for Charm spell 2");

        System.out.println("Added: \n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + s4);
        System.out.println("Stored in the map Spell By ID:");
        hogwartsSpells.getSpellById().entrySet().forEach(System.out::println);
        System.out.println("Stored in the map Spells By Type:");
        hogwartsSpells.getSpellsByType().entrySet().forEach(System.out::println);
    }
}
