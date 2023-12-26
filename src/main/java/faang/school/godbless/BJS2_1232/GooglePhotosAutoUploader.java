package faang.school.godbless.BJS2_1232;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("No new photos to upload. Waiting...");
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
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        var iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " uploaded to remote server successfully!");
            iterator.remove();
        }
    }
}