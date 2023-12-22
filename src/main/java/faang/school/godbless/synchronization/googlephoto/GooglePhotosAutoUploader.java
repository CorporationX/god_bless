package faang.school.godbless.synchronization.googlephoto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock;
    @Getter
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("%s was added ++!\n", photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.printf("%s was uploaded successfully!\n", photoPath);
        }
        photosToUpload.clear();
    }


}
