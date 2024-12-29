package school.faang.task_49481;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(player::play);
        executorService.submit(player::pause);
        executorService.submit(player::skip);
        executorService.submit(player::previous);

        executorService.shutdownNow();
    }
}
