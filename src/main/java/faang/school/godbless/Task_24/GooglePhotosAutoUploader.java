package faang.school.godbless.Task_24;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class GooglePhotosAutoUploader {

    final Object lock = new Object();
    List<String> photosToUpload;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    onNewPhotoAdded("new_photo");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                uploadPhotos();
            }
        }
    }

    void uploadPhotos() {
        System.out.println("Uploading new photos to server");
        for (String s : photosToUpload
        ) {
            photosToUpload.remove(s);
        }
    }

    void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        lock.notify();
    }
}
