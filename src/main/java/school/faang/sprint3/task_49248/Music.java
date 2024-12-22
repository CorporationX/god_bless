package school.faang.sprint3.task_49248;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static school.faang.sprint3.task_49248.PlayerActions.PAUSE;
import static school.faang.sprint3.task_49248.PlayerActions.PLAY;
import static school.faang.sprint3.task_49248.PlayerActions.PREVIOUS;
import static school.faang.sprint3.task_49248.PlayerActions.SKIP;

public class Music {
    private static final int STANDARD_DELAY = 2;
    private static final int NUM_OF_ACTIONS_TO_PERFORM = 300;

    public static void main(String[] args) {

        List<String> songList = createSongList();
        Player player = new Player(songList);

        CountDownLatch latch = new CountDownLatch(NUM_OF_ACTIONS_TO_PERFORM);

        Map<PlayerActions, Runnable> actionMethodMap = new HashMap<>();
        actionMethodMap.put(PLAY, new UserAction(latch, player::play));
        actionMethodMap.put(PAUSE, new UserAction(latch, player::pause));
        actionMethodMap.put(SKIP, new UserAction(latch, player::skip));
        actionMethodMap.put(PREVIOUS, new UserAction(latch, player::previous));

        Map<PlayerActions, ScheduledExecutorService> scheduledExecutorServicesMap = new HashMap<>();
        scheduledExecutorServicesMap.put(PLAY, Executors.newSingleThreadScheduledExecutor());
        scheduledExecutorServicesMap.put(PAUSE, Executors.newSingleThreadScheduledExecutor());
        scheduledExecutorServicesMap.put(SKIP, Executors.newSingleThreadScheduledExecutor());
        scheduledExecutorServicesMap.put(PREVIOUS, Executors.newSingleThreadScheduledExecutor());

        scheduledExecutorServicesMap.forEach((action, scheduler) ->
                scheduler.scheduleWithFixedDelay(actionMethodMap.get(action), 0, STANDARD_DELAY, TimeUnit.MILLISECONDS)
        );

        try {
            latch.await();
        } catch (InterruptedException e) {
            scheduledExecutorServicesMap.values().parallelStream().forEach(Music::shutDownScheduler);
            Thread.currentThread().interrupt();
        }

        scheduledExecutorServicesMap.values().parallelStream().forEach(Music::shutDownScheduler);

    }

    public static List<String> createSongList() {
        List<String> songList = new ArrayList<>();
        songList.add("Song A");
        songList.add("Song B");
        songList.add("Song C");
        songList.add("Song D");

        return songList;
    }

    public static void shutDownScheduler(ScheduledExecutorService scheduler) {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}