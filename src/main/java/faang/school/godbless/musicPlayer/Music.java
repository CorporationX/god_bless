package faang.school.godbless.musicPlayer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int NUMBER_OF_THREADS = 4;
    private static final Player player = new Player();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(player::play);
            executorService.execute(player::play);
            executorService.execute(player::pause);
            executorService.execute(player::pause);
            executorService.execute(player::previous);
            executorService.execute(player::previous);
            executorService.execute(player::skip);
            executorService.execute(player::skip);
        }

        executorService.shutdown();
    }
}
