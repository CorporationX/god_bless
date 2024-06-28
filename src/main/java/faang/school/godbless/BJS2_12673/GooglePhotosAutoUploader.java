package faang.school.godbless.BJS2_12673;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Picture " + photosToUpload.get(0) + " has been uploaded");
            photosToUpload.remove(0);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
