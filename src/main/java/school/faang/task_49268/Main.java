package school.faang.task_49268;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> actions = List.of(
                player::play,
                player::skip,
                player::pause,
                player::previous
        );

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (Runnable action : actions) {
            executor.submit(action);
        }

        executor.shutdown();
    }
}
