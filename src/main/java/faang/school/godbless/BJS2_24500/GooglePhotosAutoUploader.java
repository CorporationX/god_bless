package faang.school.godbless.BJS2_24500;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private Queue<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for photos to upload...");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos(photosToUpload.remove());
            }
        }
    }

    private void uploadPhotos(String path) {
        System.out.println("Uploading " + path);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Upload complete");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println("New photo added: " + photoPath);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload.add(photoPath);
            notify();
        }
    }
}
