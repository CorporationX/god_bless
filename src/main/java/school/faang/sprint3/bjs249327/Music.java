package school.faang.sprint3.bjs249327;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private final Player player = new Player();

    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Runnable> tasks = Arrays.asList(player::play, player::pause, player::skip, player::previous);

        try {
            tasks.forEach(executorService::submit);
        } catch (Exception e) {
            System.err.println("Непредвиденное исключение: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}