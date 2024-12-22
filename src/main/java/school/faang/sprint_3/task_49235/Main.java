package school.faang.sprint_3.task_49235;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Количество потоков и видео
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        // Создаём VideoManager
        VideoManager manager = new VideoManager();

        // Создаём пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Добавляем задачи в ExecutorService
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId); // Добавляем просмотр
                    System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                });
            }
        }

        // Завершаем пул потоков
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // Ждем завершения всех задач
    }
}
