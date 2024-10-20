package school.faang.godbless.bjs2_37246;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int THREADS_NUMBER = 30;

    public static void main(String[] args) throws InterruptedException {
        List<Track> tracks = List.of(
                new Track("Track 1"),
                new Track("Track 2"),
                new Track("Track 3"),
                new Track("Track 4"),
                new Track("Track 5"),
                new Track("Track 6")
        );
        Player player = new Player(tracks);
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_NUMBER);
        pool.submit(player::play);
        pool.submit(player::pause);
        pool.submit(player::previous);
        pool.submit(player::skip);
        pool.submit(player::play);
        pool.submit(player::previous);
        pool.submit(player::play);
        pool.submit(player::previous);
        pool.submit(player::previous);
        pool.submit(player::previous);
        pool.submit(player::skip);
        pool.submit(player::pause);
        pool.submit(player::previous);
        pool.submit(player::skip);
        pool.submit(player::play);
        pool.submit(player::previous);
        pool.submit(player::previous);
        pool.submit(player::previous);
        pool.submit(player::play);
        pool.submit(player::skip);
        pool.submit(player::previous);
        pool.submit(player::pause);
        pool.submit(player::previous);
        pool.submit(player::skip);
        pool.submit(player::pause);
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            System.out.println("Stopped working with the player");
        } else {
            throw new IllegalStateException("Pool not terminated");
        }
    }
}
