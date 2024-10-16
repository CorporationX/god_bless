package school.faang.spotifyBan;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 5;

    @SneakyThrows
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::play);
        executor.submit(player::play);
        executor.submit(player::skip);
        executor.submit(player::previous);
        executor.shutdown();
    }
}
