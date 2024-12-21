package school.faang.sprint_3.task_49199;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREAD_SIZE = 100;
    public static final int NUM_VIDEOS = 10;
    public static final int MAX_VIEW_COUNT = 100;
    public static final int TIMEOUT = 1;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_SIZE);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "Video#" + i;

            for (int j = 0; j < MAX_VIEW_COUNT; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info("У видео {} просмотров: {}", videoId, manager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Поток прерван при ожидании завершения задачи");
        }
        System.out.println(manager.getViewMap());
    }
}
