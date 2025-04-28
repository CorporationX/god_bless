package school.faang.bjs2_73723;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class GooglePhotosAutoUploader {

    private static final int SLEEP_TIME = 1000;
    private final List<String> photosToUpload = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition hasPhotos = lock.newCondition();
    private volatile boolean isRunning = true;

    public void startAutoUpload() {
        while (isRunning) {
            lock.lock();
            try {
                if (!photosToUpload.isEmpty()) {
                    Thread.sleep(SLEEP_TIME);
                    uploadPhotos();
                } else {
                    System.out.println("Empty for now");
                    hasPhotos.await();
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Photos upload started");
        photosToUpload.forEach(photo -> System.out.printf("Loading: %s\n", photo));
        photosToUpload.clear();
        System.out.println("All photos uploaded");
    }

    public void onNewPhotoAdded(String path) {
        lock.lock();
        try {
            Thread.sleep(SLEEP_TIME);
            photosToUpload.add(path);
            System.out.println("Photo added");
            hasPhotos.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted");
        } finally {
            lock.unlock();
        }
    }
}
