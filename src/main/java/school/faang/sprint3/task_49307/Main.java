package school.faang.sprint3.task_49307;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 3; i++) {
            executorService.submit(player::play);
            executorService.submit(player::previous);
            executorService.submit(player::pause);
            executorService.submit(player::skip);
        }

        executorService.shutdown();
    }
}
