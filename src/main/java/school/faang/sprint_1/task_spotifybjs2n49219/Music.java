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
    private static int PLAY_PRESS_PERIOD = 1;
    private static int PAUSE_PRESS_PERIOD = 4;
    private static int SKIP_PRESS_PERIOD = 2;
    private static int PRIVIOUS_PRESS_PERIOD = 2;
    private static int TIME_TO_PLAY_MILISECONDS = 7000;

    public void startSpotify() {
        Player player = new Player();
        ScheduledExecutorService scheduledMusicPlay = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        Runnable runPlay = player::play;
        Runnable runPause = player::pause;
        Runnable runSkip = player::skip;
        Runnable runPrevious = player::previous;

//        List<Runnable> actions = new ArrayList<>(List.of(
//                () -> player.play(),
//                () -> player.pause(),
//                new Thread(runSkip),
//                new Thread(runPrevious)
//        ));
//
//        for(Thread thread : threads) {
//            thread.start();
//        }

        scheduledMusicPlay.scheduleAtFixedRate(runPlay, 0, PLAY_PRESS_PERIOD, TimeUnit.SECONDS);
        scheduledMusicPlay.scheduleAtFixedRate(runPause, 0, PAUSE_PRESS_PERIOD, TimeUnit.SECONDS);
        scheduledMusicPlay.scheduleAtFixedRate(runSkip, 0, SKIP_PRESS_PERIOD, TimeUnit.SECONDS);
        scheduledMusicPlay.scheduleAtFixedRate(runPrevious, 0, PRIVIOUS_PRESS_PERIOD, TimeUnit.SECONDS);

        try {
            Thread.sleep(TIME_TO_PLAY_MILISECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        scheduledMusicPlay.shutdown();
    }
}
