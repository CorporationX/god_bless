package school.faang.third_sprint;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object LOCK = new Object();
    private static final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (LOCK) {
                while (PHOTOS_TO_UPLOAD.isEmpty()) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted while waiting for auto upload", e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(@NonNull String photo) {
        synchronized (LOCK) {
            PHOTOS_TO_UPLOAD.add(photo);
            LOCK.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : PHOTOS_TO_UPLOAD) {
            System.out.printf("Photo: %s is uploaded\n", photo);
        }
        PHOTOS_TO_UPLOAD.clear();
    }
}
