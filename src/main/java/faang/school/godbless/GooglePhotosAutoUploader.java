package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock;
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
    }
    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Uploading photo by path: " + photo);
            }
            photosToUpload.clear();
        }

    }

}
