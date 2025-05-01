package school.faang.tamagotchi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final int FEED_COUNT = 4;
    private static final int PLAY_COUNT = 4;
    private static final int CLEAN_COUNT = 4;
    private static final int SLEEP_COUNT = 4;
    private static final long ACTION_DELAY_MS = 100;

    public static void main(String[] args) {
        VladController controller = setupController();
        List<Thread> threads = startAllThreads(controller);
        waitThreadsCompletion(threads);
        printStates(controller);
    }

    private static VladController setupController() {
        VladController controller = new VladController();
        addVladsToController(controller);
        return controller;
    }

    private static void addVladsToController(VladController controller) {
        controller.addVlad(new TamagotchiVlad("Влад 1"));
        controller.addVlad(new TamagotchiVlad("Влад 2"));
        controller.addVlad(new TamagotchiVlad("Влад 3"));
    }

    private static List<Thread> startAllThreads(VladController controller) {
        List<Thread> threads = new ArrayList<>();

        threads.add(createFeedThread(controller));
        threads.add(createPlayThread(controller));
        threads.add(createCleanThread(controller));
        threads.add(createSleepThread(controller));

        threads.forEach(Thread::start);
        return threads;
    }

    private static Thread createFeedThread(VladController controller) {
        return new Thread(() -> {
            for (int i = 0; i < FEED_COUNT; i++) {
                controller.feedAll();
                sleepForMillis(ACTION_DELAY_MS);
            }
        });
    }

    private static Thread createPlayThread(VladController controller) {
        return new Thread(() -> {
            for (int i = 0; i < PLAY_COUNT; i++) {
                controller.playAll();
                sleepForMillis(ACTION_DELAY_MS);
            }
        });
    }

    private static Thread createCleanThread(VladController controller) {
        return new Thread(() -> {
            for (int i = 0; i < CLEAN_COUNT; i++) {
                controller.cleanAll();
                sleepForMillis(ACTION_DELAY_MS);
            }
        });
    }

    private static Thread createSleepThread(VladController controller) {
        return new Thread(() -> {
            for (int i = 0; i < SLEEP_COUNT; i++) {
                controller.sleepAll();
                sleepForMillis(ACTION_DELAY_MS);
            }
        });
    }

    private static void sleepForMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    private static void waitThreadsCompletion(List<Thread> threads) {
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ожидание потока было прервано", e);
                Thread.currentThread().interrupt();
            }
        });
    }

    private static void printStates(VladController controller) {
        controller.getVlads().forEach(vlad ->
                log.info("{}: {}",
                        vlad.getName(),
                        vlad.getState().getDescription())
        );
    }
}