package google_photo_sync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_THREADS = 2;
    private static final int TIME_TO_WAIT = 30;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            List<String> photos = List.of("photo1.jpg", "photo2.jpg", "photo3.jpg", "photo4.jpg", "photo5.jpg");
            photos.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });

        executorService.shutdown();

        if (executorService.awaitTermination(TIME_TO_WAIT, TimeUnit.SECONDS)) {
            System.out.println("Загрузка окончена");
        } else {
            executorService.shutdownNow();
        }
    }
}
