package school.faang.bjs249674;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SampleData {
    static List<Player> players = Collections.synchronizedList(new ArrayList<>());
    public static final int THREADS_COUNT = 10;
    public static final int TERMINATION_TIMEOUT = 5;

    @SneakyThrows
    public static void main(String[] args) {
        Boss boss = new Boss(10);
        init();
        System.out.println(players);

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        players.forEach(player ->
                executor.submit(() -> {
                    try {
                        System.out.printf("%s Adding executor on Thread: %s\n",
                                LocalDateTime.now(), Thread.currentThread().getId());
                        player.startBattle(boss);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
        );

        System.out.printf("%s Waiting for executor shutdown on thread: %s\n",
                LocalDateTime.now(), Thread.currentThread().getId());
        executor.shutdown();
        if (executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
            System.out.println("Executor terminated on timeout of " + TERMINATION_TIMEOUT + " seconds");
        } else {
            System.out.println("Executor did not terminate in the specified time of " + TERMINATION_TIMEOUT + " seconds");
            List<Runnable> droppedTasks = executor.shutdownNow();
            System.out.println("Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed.");
        }
    }

    private static void init() {
        IntStream.range(0, 20).forEach(i -> players.add(new Player(Integer.toString(i))));
    }
}
