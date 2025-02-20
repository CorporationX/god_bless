package school.faang.BJS2_61497;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        int numTreads = 4;
        House house = new House();
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");
        User user4 = new User("User 4");

        ExecutorService executorService = Executors.newFixedThreadPool(numTreads);

        executorService.submit(() -> user1.joinHouse(house));
        executorService.submit(() -> user2.joinHouse(house));
        executorService.submit(() -> user3.joinHouse(house));
        executorService.submit(() -> user4.joinHouse(house));
        executorService.submit(() -> user1.leaveHouse(house));
        executorService.submit(() -> user2.leaveHouse(house));
        executorService.submit(() -> user3.leaveHouse(house));
        executorService.submit(() -> user4.leaveHouse(house));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("All tasks finished withing 1 second");
            } else {
                System.out.println("Not all tasks finished within 1 second");
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting for all tasks to complete was interrupted");
        }

        if (!executorService.isTerminated()) {
            System.out.println("Force quit remaining tasks");
            executorService.shutdownNow();
        }
    }
}
