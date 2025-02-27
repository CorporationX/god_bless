package school.faang.sprint3.task_61473;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final int THREADS_COUNT = 3;
    private static final int THREAD_SLEEP_TIMEOUT = 2;

    public static void main(String[] args) {
        House house = new House();
        List<User> users = List.of(
                new User("Tirion", Role.LORD, house),
                new User("Jon", Role.KNIGHT, house),
                new User("Mellisandra", Role.MAGICIAN, house),
                new User("Dayneris", Role.LORD, house),
                new User("Jorah", Role.KNIGHT, house)
        );

        final ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);

        users.forEach(user -> pool.submit(user::joinHouse));
        users.forEach(user -> pool.submit(user::leaveHouse));

        pool.shutdown();
        try {
            if (!pool.awaitTermination(THREAD_SLEEP_TIMEOUT, TimeUnit.MINUTES)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOG.error("Thread was interrupted");
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
