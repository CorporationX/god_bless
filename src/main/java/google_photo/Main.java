package google_photo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        GooglePhoto googlePhoto = new GooglePhoto();
        googlePhotosAutoUploader.onNewPhotoAdded("New York city");
        googlePhotosAutoUploader.onNewPhotoAdded("Moscow city");
        googlePhotosAutoUploader.onNewPhotoAdded("Barcelona city");
        executorService.execute(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload(googlePhoto);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> System.out.println(googlePhoto.getMyPhoto()));
        googlePhotosAutoUploader.onNewPhotoAdded("Boston city");

        executorService.shutdown();
        if(!executorService.awaitTermination(10000, TimeUnit.MILLISECONDS)){
            executorService.shutdownNow();
        }else{
            System.out.println("все фото загружены");
        }

    }
}
