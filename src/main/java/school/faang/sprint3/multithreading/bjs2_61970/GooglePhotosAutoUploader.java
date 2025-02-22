package school.faang.sprint3.multithreading.bjs2_61970;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();


    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    System.out.print("\nThe photo list is empty.");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        log.warn("Thread {} was interrupted while waiting for new photo.",
                                Thread.currentThread().getName(), e);
                    }
                }
                uploadPhotos();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.warn("Thread {} was interrupted during sleep.", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("\nA photo with path %s is added in the list for uploading", photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            Iterator<String> iterator = photosToUpload.iterator();
            while (iterator.hasNext()) {
                String path = iterator.next();
                System.out.printf("\nThe photo with path %s is uploaded", path);
                iterator.remove();
            }
        }
    }
}
