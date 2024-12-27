package faang.school.godbless.sprint_3.task_48924;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_WAIT_TIME_IN_MILLISECONDS = 2_000;

    public static void main(String[] args) {
        House lannisters = new House("Lannisters", List.of(Roles.LORD, Roles.KNIGHT, Roles.MAGE), 1);
        House starks = new House("Starks", List.of(Roles.KNIGHT, Roles.MAGE), 3);

        User user1 = new User("user_1");
        User user2 = new User("user_2");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            while (true) {
                user1.joinHouse(lannisters, Roles.KNIGHT);
                try {
                    Thread.sleep(THREAD_WAIT_TIME_IN_MILLISECONDS);
                } catch (InterruptedException e) {
                    System.out.println("Произошло исключение!" + e);
                }
                user1.joinHouse(starks, Roles.KNIGHT);
            }
        });

        executorService.execute(() -> {
            while (true) {
                user2.joinHouse(lannisters, Roles.MAGE);
                try {
                    Thread.sleep(THREAD_WAIT_TIME_IN_MILLISECONDS);
                } catch (InterruptedException e) {
                    System.out.println("Произошло исключение!" + e);
                }
                user2.leaveHouse();
            }
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены!");
            }
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }
    }
}
