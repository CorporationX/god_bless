package school.faang.bjs2_73241;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        Player player = new Player();
        executorService.execute(player::play);
        executorService.execute(player::pause);
        executorService.execute(player::skip);
        executorService.execute(player::previous);
        executorService.shutdown();
    }
}
