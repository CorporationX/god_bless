package school.faang.photogoogle;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            List<String> photoList = List.of("Путь 1", "путь к фото 2",
                    "путь к новому фото", "тут фото 4", "фотография 5");
            photoList.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });

        service.submit(googlePhotosAutoUploader::startAutoUpload);

        service.submit(() -> {
            List<String> secondList = List.of("Новая фотка 1", "Новая фотка " +
                    "2", "Новая фотка 3");
            secondList.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });

        service.shutdown();
        try {
            if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

