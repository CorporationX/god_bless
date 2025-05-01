package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("waiting new photo...");
                        lock.wait();
                    }
                    System.out.println("Uploading photo:");
                    uploadPhotos();
                } catch (InterruptedException e) {
                    log.error("Поток загрузки был прерван");
                    Thread.currentThread().interrupt();
                } finally {
                    log.info("Поток загрузки завершает работу");
                }
            }
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Uploading new photo: - " + photo);
        }
        photosToUpload.clear();
        System.out.println("Photos are uploaded!!!");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Added new photo: " + photoPath);
            lock.notify();
        }
    }
}
