package school.faang.bjs249266;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static final int NUMBER_THREADS = 100;
    public static final int NUMBER_VIDEOS = 10;
    private static final long TIMEOUT_WORK_FINISH = 5;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);

        for (int i = 0; i < NUMBER_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUMBER_THREADS / NUMBER_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_WORK_FINISH, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            log.error("Error interrupted exception! {}", String.valueOf(ex));
        }
    }
}
