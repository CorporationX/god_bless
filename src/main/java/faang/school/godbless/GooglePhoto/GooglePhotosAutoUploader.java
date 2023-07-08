package faang.school.godbless.GooglePhoto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private volatile List<String> uploadedPhotos = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println(photo + " uploading");
                uploadedPhotos.add(photo);
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
