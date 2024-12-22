package school.faang.sprint3.task10;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        User user1 = new User("Иван");
        User user2 = new User("Петр");
        User user3 = new User("Федор");


        House house = new House(List.of("Десница", "Мастер над монетой"), "Таргариены");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        executor.submit(() -> user1.joinHouse(house, house.getRoles().get(0)));
        executor.submit(user1::leaveHouse);

        executor.submit(() -> user2.joinHouse(house, house.getRoles().get(1)));
        executor.submit(user2::leaveHouse);

        executor.submit(() -> user3.joinHouse(house, house.getRoles().get(0)));
        executor.submit(user3::leaveHouse);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
