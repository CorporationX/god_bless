package the_iron_throne_at_any_cost;

import java.util.List;

public class Westeros {
    /**
     * The main method initializes a Stark house with specific roles and creates User objects for Jon Snow, Arya Stark, and Sansa Stark.
     * Three threads are started to assign each user to a different role in the Stark house.
     * After 3 seconds, Jon Snow leaves the house.
     */
    public static void main(String[] args) {
        House starkHouse = new House("House Stark", List.of("Warden of the North", "Knight", "Soldier"));

        User jon = new User("Jon Snow");
        User arya = new User("Arya Stark");
        User sansa = new User("Sansa Stark");

        Thread t1 = new Thread(() -> {
            jon.joinHouse(starkHouse, "Warden of the North");
        });

        Thread t2 = new Thread(() -> {
            arya.joinHouse(starkHouse, "Knight");
        });

        Thread t3 = new Thread(() -> {
            sansa.joinHouse(starkHouse, "Soldier");
        });

        t1.start();
        t2.start();
        t3.start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                jon.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
