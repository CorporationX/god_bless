package school.faang.iron_throne_BJS2_37058;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public final static int AWAITING_TIME = 3;
    public final static int THREADS_COUNTER = 7;

    public static void main(String[] args) throws InterruptedException {
        List<String> roles = new ArrayList<>(Arrays.asList(
                "Knight", "Mage", "Paladin", "Assassin",
                "Berserker", "Alchemist"
        ));
        House house = new House(roles, 4);

        User user1 = new User("Arthur", house, house.getRoles().get(0));
        User user2 = new User("Merlin", house, house.getRoles().get(1));
        User user3 = new User("Lancelot", house, house.getRoles().get(2));
        User user4 = new User("Ezio", house, house.getRoles().get(3));
        User user5 = new User("Thorin", house, house.getRoles().get(4));
        User user6 = new User("Nicolas", house, house.getRoles().get(5));

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5, user6));

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNTER);
        for (User user : users) {
            executorService.submit(user::joinHouse);
        }

        executorService.shutdown();

        if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
            System.out.println("All users joined!");
        } else {
            System.out.println("Awaiting time is over.Not all users joined!");
            executorService.shutdownNow();
        }
    }
}
