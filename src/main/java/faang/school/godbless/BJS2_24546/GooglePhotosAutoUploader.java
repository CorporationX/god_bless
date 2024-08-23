package faang.school.godbless.BJS2_24546;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {

        long endTime = System.currentTimeMillis() + 5 * 60 * 1000;

        while (System.currentTimeMillis() < endTime) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println("New photo was added, photo's to upload: " + photosToUpload.size());
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            try {
                Thread.sleep(photosToUpload.size() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(photosToUpload.size() + " photo uploaded to server");
            photosToUpload.clear();
        }
    }
}
