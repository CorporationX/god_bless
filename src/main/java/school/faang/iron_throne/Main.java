package school.faang.iron_throne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL = 2;

    public static void main(String[] args) {
        House house = new House();
        User userOne = new User("Bob");
        User userTwo = new User("Rob");
        User userTree = new User("Jo");
        User userFour = new User("Tim");
        User userFive = new User("Mo");

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        executorService.submit(() -> userOne.joinHouse(house));
        executorService.submit(() -> userTwo.joinHouse(house));
        executorService.submit(() -> userTree.joinHouse(house));
        executorService.submit(() -> userFour.joinHouse(house));
        executorService.submit(userTwo::leaveHouse);
        executorService.submit(() -> userFive.joinHouse(house));
        executorService.shutdown();
        try {
            executorService.awaitTermination(18, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}