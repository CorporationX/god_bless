package school.faang.sprint_1.task_spotifybjs2n49219;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static int NUMBER_OF_THREADS = 4;
    private static int PRESS_PERIOD = 1;
    private static int TIME_TO_PLAY_MILISECONDS = 7000;

    public void startSpotify() {
        Player player = new Player();
        ScheduledExecutorService scheduledMusicPlay = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        List<Runnable> runActions = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        );

        for (Runnable runnable : runActions) {
            scheduledMusicPlay.scheduleAtFixedRate(runnable, 0, PRESS_PERIOD++, TimeUnit.SECONDS);
        }


        try {
            Thread.sleep(TIME_TO_PLAY_MILISECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        scheduledMusicPlay.shutdown();
    }
}
