package school.faang.task_48814;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_AMOUNT = 8;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        List<User> users = new ArrayList<>(List.of(
                new User("Norair", null, house),
                new User("Egor", null, house),
                new User("Hke", null, house),
                new User("Who", null, house),
                new User("Mike", null, house),
                new User("Lo", null, house),
                new User("John", null, house),
                new User("Goo", null, house)
        ));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (int i = 0; i < users.size(); i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    users.get(finalI).joinHouse();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.execute(() -> {
            users.get(0).leaveHouse();
            users.get(1).leaveHouse();
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
