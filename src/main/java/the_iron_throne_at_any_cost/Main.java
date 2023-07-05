package the_iron_throne_at_any_cost;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House houseOfLannister = new House("Lannisters", 4);
        House houseOfStark = new House("Starks", 3);

        ExecutorService executorService = Executors.newCachedThreadPool();

        User cersei = new User("Cersei",true);
        User tywin = new User("Tywin",true);
        User joffrey = new User("Joffrey",true);
        User tyrion = new User("Tyrion",false);
        User jaime = new User("Jaime",true);
        User arya = new User("Arya",false);
        User rob = new User("Rob",true);
        User ned = new User("Ned",true);
        User sansa = new User("Sansa",false);

        Semaphore lannisterSemaphore = new Semaphore(houseOfLannister.getNumberOfAvailableRoles());
        Semaphore starkSemaphore = new Semaphore(houseOfStark.getNumberOfAvailableRoles());

        List<Runnable> actions = Arrays.asList(
                () -> executeAction(cersei, houseOfLannister, "queen mother", lannisterSemaphore),
                () -> executeAction(tywin, houseOfLannister, "hand of the king", lannisterSemaphore),
                () -> executeAction(joffrey, houseOfLannister, "king", lannisterSemaphore),
                () -> executeAction(tyrion, houseOfLannister, "hand of the king", lannisterSemaphore),
                () -> executeAction(jaime, houseOfLannister, "knight of the royal guard", lannisterSemaphore),
                () -> executeAction(arya, houseOfStark, "lady of Winterfell", starkSemaphore),
                () -> executeAction(rob, houseOfStark, "king of the North", starkSemaphore),
                () -> executeAction(ned, houseOfStark, "lord of Winterfell", starkSemaphore),
                () -> executeAction(sansa, houseOfStark, "queen of the North", starkSemaphore)
        );

        for (Runnable action : actions) {
            executorService.submit(action);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executeAction(User user, House house, String role, Semaphore semaphore) {
        try {
            semaphore.acquire();
            user.joinHouse(house, role);
            if (user.isWillBeDead()) {
                user.leaveHouse();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
