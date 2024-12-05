package school.faang.sprint1.task_44561;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Adding spell Events
        for (int i = 1; i <= 10; i++) {
            HogwartsSpells.addSpellEvent(i, "some spell event " + i, "some action" + i);
        }
        System.out.println("Adding an existing spell event");
        System.out.println(HogwartsSpells.addSpellEvent(5, "some spell event " + 5, "some action" + 5));


        try {
            System.out.println("Getting an existing spell event by id");
            System.out.println("Getting by id " + HogwartsSpells.getSpellEventById(5));

            System.out.println("Getting non existing spell event");
            System.out.println("Getting by id " + HogwartsSpells.getSpellEventById(15));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("Getting an existing spell by type");
            System.out.println("Getting by type: " + HogwartsSpells.getSpellEventsByType("some spell event 5"));

            System.out.println("Getting non existing spell event");
            System.out.println("Getting by type: " + HogwartsSpells.getSpellEventsByType("some spell event 15"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Deleting an existing spell event");
        System.out.println(HogwartsSpells.deleteSpellEvent(4));


        try {
            System.out.println("Deleting non existing spell event");
            System.out.println(HogwartsSpells.deleteSpellEvent(15));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        HogwartsSpells.printAllSpellEvents();
    }
}
