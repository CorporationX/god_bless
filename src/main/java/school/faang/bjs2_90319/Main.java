package school.faang.bjs2_90319;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AWAIT_TERMINATE_MIN = 1;
    private static final int TIME_IN_HOUSE = 2000;

    public static void main(String[] args) {
        House house = new House(List.of("Лорд", "Рыцарь", "Маг"));

        User jon = new User("Джон");
        User arya = new User("Арья");
        User tyrion = new User("Тирион");
        User daenerys = new User("Дайнерис");
        User cersei = new User("Серсея");

        List<User> users = List.of(jon, arya, tyrion, daenerys, cersei);

        ExecutorService executor = Executors.newFixedThreadPool(users.size());

        for (User user : users) {
            executor.submit(() -> {
                user.joinHouse(house);

                try {
                    Thread.sleep(TIME_IN_HOUSE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                user.leaveHouse();
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATE_MIN, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
