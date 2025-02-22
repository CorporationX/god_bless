package school.faang.task_61473;

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
        List<User> users = List.of(
                new User("Tirion", "lord"),
                new User("Jon", "knight"),
                new User("Mellisandra", "magician"),
                new User("Dayneris", "lord"),
                new User("Jorah", "knight")
        );

        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        users.forEach(user -> pool.submit(user::joinHouse));

        pool.shutdown();
        try {
            if (!pool.awaitTermination(THREAD_SLEEP_TIMEOUT, TimeUnit.MINUTES)) {
                pool.shutdown();
            }
        } catch (InterruptedException e) {
            pool.shutdown();
            LOG.info("Thread was interrupted while waiting");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
