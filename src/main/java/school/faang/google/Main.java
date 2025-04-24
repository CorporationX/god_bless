package school.faang.google;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> {
            try {
                googlePhoto.startAutoUpload();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                googlePhoto.onNewPhotoAdded("Wald");
                googlePhoto.onNewPhotoAdded("Berg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Есть не загруженные фотографии");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
