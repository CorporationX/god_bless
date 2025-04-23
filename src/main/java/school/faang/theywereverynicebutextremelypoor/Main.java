package school.faang.theywereverynicebutextremelypoor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running Chore & WeasleyFamily.threadSet() tests ===");

        testChoreRunnable();
        testChoreRunDoesNotThrow();
        testThreadSetNormal();
        testThreadSetEmptyList();

        System.out.println("=== All tests finished ===");
    }

    private static void testChoreRunnable() {
        System.out.print("testChoreRunnable: ");
        Chore chore = new Chore("do the dishes");
        if (!"do the dishes".equals(chore.getChore())) {
            throw new AssertionError("Chore name not set correctly");
        }
        System.out.println("PASS");
    }

    private static void testChoreRunDoesNotThrow() {
        System.out.print("testChoreRunDoesNotThrow: ");
        Chore chore = new Chore("sweep the floor");
        try {
            chore.run();
            System.out.println("PASS");
        } catch (Throwable t) {
            throw new AssertionError("Chore.run() threw an exception", t);
        }
    }

    private static void testThreadSetNormal() {
        System.out.print("testThreadSetNormal: ");
        List<Chore> chores = Arrays.asList(
                new Chore("cook dinner"),
                new Chore("water the plants"),
                new Chore("walk the cat")
        );
        WeasleyFamily family = new WeasleyFamily(chores);
        try {
            family.threadSet();
            System.out.println("PASS");
        } catch (Throwable t) {
            throw new AssertionError("threadSet() failed on normal list", t);
        }
    }

    private static void testThreadSetEmptyList() {
        System.out.print("testThreadSetEmptyList: ");
        WeasleyFamily family = new WeasleyFamily(Collections.emptyList());
        try {
            family.threadSet();
            System.out.println("PASS");
        } catch (Throwable t) {
            throw new AssertionError("threadSet() failed on empty list", t);
        }
    }
}
