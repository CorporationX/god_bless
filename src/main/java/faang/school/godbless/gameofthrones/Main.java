package faang.school.godbless.gameofthrones;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int N_THREADS = 4;

    public static void main(String[] args) {
        House house = new House();
        List<User> users = initialize(house);

        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

        for (User user : users) {
            executorService.execute(user::joinHouse);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        for (User user : users) {
            executorService.execute(() -> {
                if (user.getRole() != null) {
                    user.leaveHouse();
                }
            });
        }
        executorService.shutdown();
    }

    private static List<User> initialize(House house) {
        return List.of(
                new User("user_1", house),
                new User("user_2", house),
                new User("user_3", house),
                new User("user_4", house),
                new User("user_5", house),
                new User("user_6", house),
                new User("user_7", house),
                new User("user_8", house),
                new User("user_9", house),
                new User("user_10", house),
                new User("user_11", house),
                new User("user_12", house)
        );
    }
}
