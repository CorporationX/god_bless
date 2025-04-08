package school.faang.bjs248633;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int COLLECT_INTERVAL_SECONDS = 5;
    private static final int WAIT_TIME_SECONDS = 120;

    public static void main(String[] args) {

        House house = new House();
        house.initialize();

        CountDownLatch latch = house.getRoomClearLatch();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        log.info("ScheduledExecutorService created with {} threads.", THREAD_POOL_SIZE);

        scheduledExecutorService.scheduleAtFixedRate(
                house::collectFood,
                0,
                COLLECT_INTERVAL_SECONDS,
                TimeUnit.SECONDS
        );

        boolean allRoomsEmptied = false;
        try {
            allRoomsEmptied = latch.await(WAIT_TIME_SECONDS, TimeUnit.SECONDS);
            if (allRoomsEmptied) {
                log.info("All rooms are empty (CountDownLatch reached zero).");
            } else {
                log.warn("Not all rooms emptied within {} seconds.", WAIT_TIME_SECONDS);
            }
        } catch (InterruptedException ex) {
            log.error("Main thread interrupted while waiting for latch.", ex);
            Thread.currentThread().interrupt();
        }

        scheduledExecutorService.shutdown();
        log.info("Shutdown initiated for scheduler. Waiting for tasks to complete...");

        try {
            if (scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.info("All scheduled tasks finished. House food collection ended.");
            } else {
                log.warn("Some tasks did not complete within 60 seconds. Forcing shutdown now...");
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while awaiting scheduler termination.", e);
            Thread.currentThread().interrupt();
        }

        log.info("Process complete. Check logs for collected food details.");
        System.out.println("All done! Food collection with scheduleAtFixedRate finished.");
    }
}