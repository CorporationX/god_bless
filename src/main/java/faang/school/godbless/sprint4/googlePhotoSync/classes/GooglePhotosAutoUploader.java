package faang.school.godbless.sprint4.googlePhotoSync.classes;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object LOCK = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (LOCK) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for photos to upload...");
                    LOCK.wait();
                }
                uploadPhotos(photosToUpload);
            }
        }
    }

    private void uploadPhotos(List<String> photoToUpload) {
        synchronized (LOCK) {
            photoToUpload.forEach(
                    photo -> System.out.println("Uploading photo: " + photo)
            );
            photoToUpload.clear();
            LOCK.notifyAll();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (LOCK) {
            photosToUpload.add(photoPath);
            LOCK.notifyAll();
        }
    }
}