package faang.school.godbless.BJS224566;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private Queue<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for new photos...");
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        String photo = photosToUpload.poll();
        if (photo != null) {
            System.out.println("Uploading photo: " + photo);
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }
}
