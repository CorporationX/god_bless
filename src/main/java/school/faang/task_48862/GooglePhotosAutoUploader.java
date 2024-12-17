package school.faang.task_48862;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        this.lock = new Object();
        this.photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        try {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(log::info);
        photosToUpload.clear();
    }

}
