package school.faang.multithreading.spotify;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Music {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        Player player = new Player();

        executorService.scheduleAtFixedRate(player::play, 0, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(player::skip, 0, 7, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(player::pause, 0, 10, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(player::previous, 0, 17, TimeUnit.SECONDS);
    }
}
