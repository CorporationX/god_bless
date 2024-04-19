package faang.school.godbless.synchronization.googlePhotos;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        String newPhotoPath1 = "/src/Google_drive/new_image_from_beach.png";
        String newPhotoPath2 = "/src/Google_drive/new_image_from_forest.png";
        String newPhotoPath3 = "/src/Google_drive/new_image_from_village.png";
        String newPhotoPath4 = "/src/Google_drive/new_image_from_college.png";


        log.info("Starting auto uploading.");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(autoUploader::startAutoUpload);
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath1));
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath2));
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath3));
        executorService.submit(() -> autoUploader.onNewPhotoAdded(newPhotoPath4));


        try {
            Thread.sleep(5000);
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted during waiting of termination of thread pool.", e);
        }

        log.info("Auto uploading terminated.");
    }
}
