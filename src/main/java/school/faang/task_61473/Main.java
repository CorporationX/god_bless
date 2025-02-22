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
        House house = new House();
        List<User> users = List.of(
                new User("Tirion", "lord", house),
                new User("Jon", "knight", house),
                new User("Mellisandra", "magician", house),
                new User("Dayneris", "lord", house),
                new User("Jorah", "knight", house)
        );

        final ExecutorService poolJoin = Executors.newFixedThreadPool(THREADS_COUNT);
        final ExecutorService poolLeave = Executors.newFixedThreadPool(THREADS_COUNT);
        users.forEach(user -> poolJoin.submit(user::joinHouse));
        users.forEach(user -> poolJoin.submit(user::leaveHouse));
        poolJoin.shutdown();
        poolLeave.shutdown();

        try {
            if (!poolJoin.awaitTermination(THREAD_SLEEP_TIMEOUT, TimeUnit.MINUTES)
                    || !poolLeave.awaitTermination(THREAD_SLEEP_TIMEOUT, TimeUnit.MINUTES)) {
                poolJoin.shutdownNow();
                poolLeave.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOG.error("Thread was interrupted");
            poolJoin.shutdownNow();
            poolLeave.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
