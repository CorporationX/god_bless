package school.faang.ironthrone;

import java.util.List;

public class Main {
    private static final int ROLE_ASSIGNMENT_DELAY_MS = 5000;

    public static void main(String[] args) {
        House stark = new House(List.of("King", "Warrior"));
        House lannister = new House(List.of("Knight", "Hand of the King"));
        User john = new User("John");
        User tyrion = new User("Tyrion");
        Thread threadStark = new Thread(() -> {
            try {
                john.joinHouse(stark);
                Thread.sleep(ROLE_ASSIGNMENT_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while joining the house", e);
            } finally {
                john.leaveHouse(stark);
            }
        });
        Thread threadLannister = new Thread(() -> {
            try {
                tyrion.joinHouse(lannister);
                Thread.sleep(ROLE_ASSIGNMENT_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while joining the house", e);
            } finally {
                tyrion.leaveHouse(lannister);
            }
        });
        threadStark.start();
        threadLannister.start();
        try {
            threadStark.join();
            threadLannister.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for it to finish", e);
        }
    }
}