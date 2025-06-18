package school.faang.bjs2_81742;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::skip);
        executor.submit(player::previous);

        executor.shutdown();
    }
}
