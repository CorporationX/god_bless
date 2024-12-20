package school.faang.task_48886;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIMEOUT = 20;
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        executorService.submit(GooglePhotosAutoUploader::startAutoUpload);

        executorService.submit(() -> {
            for (int i = 1; i <= 10; i++) {
                String photoName = "photo_" + i;
                System.out.println("идет процесс добавления новой фотографии: " + photoName + ".jpg");
                GooglePhotosAutoUploader.onNewPhotoAdded(photoName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("Задачи не завершились за 20 секунд, принудительно останавливаем...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}