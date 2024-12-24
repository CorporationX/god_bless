package school.faang.task_49265;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final long EXECUTING_TIME = 60;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();
        List<String> videos = List.of(
                "Приключения в лесу",
                "Как приготовить пасту",
                "Топ 10 мест для путешествий",
                "Секреты успешного бизнеса",
                "Уроки по рисованию для начинающих",
                "Научные эксперименты для детей",
                "Обзор новых технологий",
                "Фитнес-тренировка на каждый день",
                "Лучшие фильмы 2023 года",
                "Как научиться играть на гитаре"
        );
        Random random = new Random();
        videoManager.addVideos(videos);


        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            var index = random.nextInt(videos.size());
            executor.submit(() -> videoManager.addView(videos.get(index)));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(EXECUTING_TIME, TimeUnit.SECONDS)) {
                log.error("Not all tasks were completed within the specified time period");
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Error occurred: {}", ex.getMessage());
            executor.shutdownNow();
        }

        videos.forEach((video) -> log.info("{} - {}", video,
                videoManager.getViewCount(video)));
        int viewsCount = videos.stream().map(videoManager::getViewCount).reduce(0, Integer::sum);
        log.info("Всего просмотров: {}", viewsCount);
    }
}
