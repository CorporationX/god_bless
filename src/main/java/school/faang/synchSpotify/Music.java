package school.faang.synchSpotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.submit(player::play);
        executor.submit(player::skip);
        executor.submit(player::previous);
        executor.submit(player::pause);
        executor.submit(player::pause);
        executor.submit(player::skip);
        executor.submit(player::play);
        executor.shutdown();
    }
}
