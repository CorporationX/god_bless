package school.faang.googlephotosync;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition newPhotoCondition = lock.newCondition();

    public void startAutoUpload() {
        while (true) {
            lock.lock();
            try {
                while (photosToUpload.isEmpty()) {
                    System.out.println("No new photos. Waiting for new photos to be added...");
                    newPhotoCondition.await();
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Upload process interrupted.");
            } finally {
                lock.unlock();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        lock.lock();
        try {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            newPhotoCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    private void uploadPhotos() {
        photosToUpload.stream().collect(Collectors.toList()).forEach(photo -> {
            System.out.println("Uploading photo: " + photo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        photosToUpload.clear();
        System.out.println("All photos uploaded.");
    }
}

