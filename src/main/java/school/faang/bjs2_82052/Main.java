package school.faang.bjs2_82052;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_OF_THREADS = 3;
    private static final int TERMINATION_TIMEOUT = 5;
    private static final TimeUnit TIME_UNIT_OF_AWAIT_TERMINATOR = TimeUnit.SECONDS;

    public static void main(String[] args) {
        List<Role> starksRoles = new ArrayList<>() {{
                add(Role.KING);
                add(Role.KNIGHT);
            }
        };
        House starks = new House(starksRoles);
        List<User> users = List.of(
                new User("A", starks),
                new User("B", starks),
                new User("C", starks),
                new User("D", starks),
                new User("F", starks)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);

        for (User user : users) {
            executorService.submit(user::joinHouse);
            executorService.submit(user::leaveHouse);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TIME_UNIT_OF_AWAIT_TERMINATOR)) {
                System.out.println("Time out");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}
