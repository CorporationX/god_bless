package faang.school.godbless.Task_24;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class GooglePhotosAutoUploader {
    String lock;
    List<String> photosToUpload;

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
