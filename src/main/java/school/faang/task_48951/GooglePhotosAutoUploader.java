package school.faang.task_48951;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("There are no photos. Thread is waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (var photo : photosToUpload) {
                System.out.println("Photo with path '" + photo + "' is uploaded to Google Photos server");
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo with path '" + photoPath + "' is added to loader");
            lock.notify();
        }
    }
}
