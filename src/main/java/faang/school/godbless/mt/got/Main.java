package faang.school.godbless.mt.got;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int WAIT_TIME = 2000;
    private static final int EXECUTOR_TIMEOUT = 20000;

    public static void main(String[] args) throws InterruptedException {
        House house1 = new House("Knights", List.of("Lord", "Knight", "Wizard"));
        House house2 = new House("Archers", List.of("Swordsman", "Archer"));

        List<User> users = List.of(new User("Bob"), new User("Alex"), new User("Gage"),
                new User("Victor"), new User("Steve"), new User("Lux"));

        List<Runnable> tasks = users.stream().map(user -> (Runnable) () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    user.joinHouse(house1);
                    Thread.sleep(WAIT_TIME);
                    user.leaveHouse();
                    Thread.sleep(WAIT_TIME);
                    user.joinHouse(house2);
                    Thread.sleep(WAIT_TIME);
                    user.leaveHouse();
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).toList();

        ExecutorService executor = Executors.newFixedThreadPool(users.size());
        tasks.forEach(executor::submit);
        executor.shutdown();

        if (!executor.awaitTermination(EXECUTOR_TIMEOUT, TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
        }
    }
}
