package school.faang.task_48839;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int MAX_ROLES = 2;

    public static void main(String[] args) {
        House houseStark = new House("Stark", MAX_ROLES, Arrays.asList(Roles.MAGE.toString(),
                Roles.LORD.toString(), Roles.KNIGHT.toString()));
        addUsersToHouse(houseStark);
    }

    private static void addUsersToHouse(House houseStark) {
        User userA = new User("Artem");
        User userB = new User("Anton");
        User userC = new User("Sveta");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> userA.joinHouse(houseStark, houseStark.getRoles().get(new Random().nextInt(houseStark.getRoles().size()))));
        executor.execute(() -> userB.joinHouse(houseStark, houseStark.getRoles().get(new Random().nextInt(houseStark.getRoles().size()))));
        executor.execute(() -> userC.joinHouse(houseStark, houseStark.getRoles().get(new Random().nextInt(houseStark.getRoles().size()))));

        executor.execute(userA::leaveHouse);
        executor.execute(userB::leaveHouse);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
