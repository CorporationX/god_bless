package faang.school.godbless.sprint3.BJS2_6324;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (!Thread.interrupted()) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("List is empty. Waiting...");

                    try {
                        lock.wait();
                    } catch (InterruptedException exception) {
                        throw new RuntimeException(exception);
                    }
                }

                uploadPhotos();
            }
        }
    }

    public void addNewPhoto(String photoPath) {
        synchronized (lock) {
            System.out.println("Add new photo to upload: " + photoPath);
            photosToUpload.add(photoPath);

            try {
                lock.notify();
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    private void uploadPhotos() {
        System.out.println("Upload photos...");
        photosToUpload.forEach(photo -> System.out.println(photo + " was uploaded"));
        System.out.println("All photos uploaded to server");
        photosToUpload.clear();
    }
}