package school.faang.task_49368;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::skip);
        executor.submit(player::previous);

        executor.shutdown();
    }
}
