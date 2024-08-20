package faang.school.godbless.modul3.photosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(autoUploader::startAutoUpload);
        System.out.println("Starting auto uploading.");

        String newPhotoPath1 = "/src/recourse/forest.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath1));
        String newPhotoPath2 = "/src/recourse/beach.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath2));
        String newPhotoPath3 = "/src/recourse/village.png";
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath3));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();

        System.out.println("Auto uploading done.");
    }

}
