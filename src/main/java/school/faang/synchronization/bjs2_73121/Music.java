package school.faang.synchronization.bjs2_73121;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Music {
    private static final Player player = new Player();

    public static void main(String[] args) {
        List<Runnable> tasks = List.of(
                player::play,
                player::pause,
                player::play,
                player::skip,
                player::skip,
                player::previous,
                player::pause,
                player::skip
        );

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
