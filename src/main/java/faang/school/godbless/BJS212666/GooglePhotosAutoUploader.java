package faang.school.godbless.BJS212666;

import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<Path> photosToUpload = new ArrayList<>();
    private boolean isActive;

    public void startAutoUpload() {
        synchronized (lock) {
            isActive = true;
            System.out.println("Time to start working");
            while (isActive) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrupted, while tried to wait notify", e);
                    }
                }
                uploadPhotos();
            }
        }

    }

    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Start upload new photos:");
            photosToUpload.forEach(System.out::println);
            photosToUpload.clear();
            try {
                Thread.sleep(5000);
                System.out.println("Finish upload new photos");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted while program tried to upload new photos", e);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(Path.of(photoPath));
            System.out.println("New photo added to upload: " + photoPath);
            lock.notify();
        }
    }

    public void turnOf() {
        isActive = false;
        System.out.println("Time to finish working");
    }
}
