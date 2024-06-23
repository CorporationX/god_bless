package BJS2_12658;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GooglePhotosAutoUploader {

    private List<String> photosToUpload = new ArrayList<>();
    private static List<String> newPhotos;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        newPhotos = List.of(
                "Photo1",
                "Photo2",
                "Photo3"
        );

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(autoUploader::startAutoUpload);
        executorService.execute(() -> newPhotos.forEach(autoUploader::onNewPhotoAdded));

        executorService.shutdown();
    }

    public void startAutoUpload() {

        synchronized (photosToUpload) {
            while (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (photosToUpload) {
            System.out.printf("Add new photo: %s\n", photo);

            photosToUpload.add(photo);
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        photosToUpload.forEach(photo -> System.out.printf("Photo uploaded to server: %s\n", photo));
        photosToUpload.clear();
    }
}