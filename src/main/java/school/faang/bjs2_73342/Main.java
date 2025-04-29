package school.faang.bjs2_73342;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static school.faang.bjs2_73342.Role.KNIGHT;
import static school.faang.bjs2_73342.Role.LORD;
import static school.faang.bjs2_73342.Role.MAGE;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;

    private static final int MAX_WAIT_SECONDS = 60;

    public static void main(String[] args) {
        House starkHouse = new House("Stark", Set.of(KNIGHT, LORD, MAGE));

        List<User> users = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_THREADS)
                .forEach(i -> users.add(new User("Player" + (i + 1))));

        users.forEach(user -> executorService.execute(() -> {
            user.joinHouse(starkHouse);
            try {
                Thread.sleep(getRoleTime());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new ThreadStoppageException(ex);
            } finally {
                user.leaveHouse(starkHouse);
            }
        }));

        gracefullyShutdown(executorService, starkHouse);
    }

    private static void gracefullyShutdown(ExecutorService executorService, House house) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_WAIT_SECONDS, SECONDS);
            if (!isClose) {
                log.error("Max expectation has been exceeded, threads are forced to terminate");
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stoppage error");
            executorService.shutdownNow();
        }
        log.info("All users have completed their work.");
        house.logRemainingAssignments();
    }

    private static long getRoleTime() {
        return (long) (Math.random() * 3000);
    }
}
