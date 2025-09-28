package school.faang.bjs2_90389;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        User[] users = {
                new User("John Snow", null),
                new User("Daenerys", null),
                new User("Tyrion", null),
                new User("Arya", null),
                new User("Sansa", null),
                new User("Bran", null)
        };

        Roles[] desiredRoles = {
                Roles.WARRIOR, Roles.WARRIOR, Roles.MAGE,
                Roles.ARCHER, Roles.MAGE, Roles.ARCHER
        };

        for (int i = 0; i < users.length; i++) {
            final int index = i;
            executor.execute(() -> {
                users[index].joinHouse(house, desiredRoles[index]);
                users[index].leaveHouse(house);
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
}
