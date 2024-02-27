package faang.school.godbless.spotifyblocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(player::play);
        executorService.submit(player::pause);
        executorService.submit(player::skip);
        executorService.submit(player::previous);
        executorService.submit(() -> player.playSpecificSong(new Song("Lovely", "Billie Eilish")));
        executorService.submit(() -> player.playSpecificSong(new Song("Lovely", "Billie Eilish")));

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
