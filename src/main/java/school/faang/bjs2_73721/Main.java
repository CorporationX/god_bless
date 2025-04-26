package school.faang.bjs2_73721;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Runnable uploadPhotos = uploader::startAutoUpload;
        Runnable addPhotos = () -> {
            for (int i = 1; i < 100; i++) {
                String newPhoto = "/photos/photo" + i + ".jpg";
                uploader.onNewPhotoAdded(newPhoto);
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(addPhotos);
        executor.execute(uploadPhotos);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
