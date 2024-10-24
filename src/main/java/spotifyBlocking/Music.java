package spotifyBlocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Player player = new Player();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                es.submit(player::play);
            } else {
                es.submit(player::pause);
            }
        }

        es.shutdown();
    }
}
