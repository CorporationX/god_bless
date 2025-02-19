package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final Boss DRAGON = new Boss();
    private static final List<Player> PLAYERS = List.of(
            new Player("Max"), new Player("Bob"), new Player("Alex"),
            new Player("Nick"), new Player("Sergey"), new Player("Andrey"),
            new Player("Alina"), new Player("Alena"), new Player("Kate")
    );
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(PLAYERS.size());
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) throws InterruptedException {
        PLAYERS.forEach(player -> EXECUTOR.submit(() -> executeWithException(() -> player.doBattle(DRAGON))));
        EXECUTOR.shutdown();
        boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        if (isTerminated) {
            log.info("Dragon is DEAD");
        } else {
            log.warn("Dragon flew far far away. Players lost");
            EXECUTOR.shutdownNow();
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
