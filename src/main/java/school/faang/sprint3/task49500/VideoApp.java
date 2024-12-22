package school.faang.sprint3.task49500;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoApp {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        List<String> videos = new ArrayList<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add("Video " + i);
        }

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                Random random = new Random();
                int videoNum = random.nextInt(NUM_VIDEOS);
                String videoId = videos.get(videoNum);
                videoManager.addView(videoId);
                log.info("Зарегистрирован просмотр видео {}. Всего просмотров : {}",
                        videos.get(videoNum),
                        videoManager.getViewCount(videoId));
            });
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Общий результат:");
        int cnt = 0;
        for (int i = 0; i < NUM_VIDEOS; i++) {
            log.info("Кол-во просмотров видео {}} : {}", videos.get(i), videoManager.getViewCount(videos.get(i)));
            cnt += videoManager.getViewCount(videos.get(i));
        }

        log.info("Всего зарегистрировано просмотров : {}. Ожидаемое значение: {}", cnt, NUM_THREADS);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}
