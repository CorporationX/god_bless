package school.faang.sprint3.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Wait for photos to upload");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println(photo + " загружено на сервер Google");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(List<String> newPhotos) {
        synchronized (lock) {
            photosToUpload.addAll(newPhotos);
            System.out.println("New photos are added");
            lock.notify();
        }
    }
}
