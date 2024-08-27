package faang.school.godbless.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private volatile boolean running = true;

    public void startAutoUpload() {
        while (running) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Auto-upload interrupted.");
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println(Thread.currentThread().getName() + ": Uploading photo: " + photo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Upload interrupted.");
                }
            }
            photosToUpload.clear();
            System.out.println(Thread.currentThread().getName() + ": All photos uploaded.");
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(Thread.currentThread().getName() + ": New photo added: " + photoPath);
            lock.notify();
        }
    }

    public void stop() {
        synchronized (lock) {
            running = false;
            lock.notifyAll();
        }
    }
}
