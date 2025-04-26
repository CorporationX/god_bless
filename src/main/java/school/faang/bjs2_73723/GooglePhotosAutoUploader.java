package school.faang.bjs2_73723;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class GooglePhotosAutoUploader {

    private List<String> photosToUpload;
    private final Lock lock = new ReentrantLock();
    private final Condition hasPhotos = lock.newCondition();
    private volatile boolean isRunning = true;

    public GooglePhotosAutoUploader(List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public void startAutoUpload() {
        while (isRunning) {
            lock.lock();
            try {
                if (!photosToUpload.isEmpty()) {
                    Thread.sleep(4000);
                    uploadPhotos();
                    photosToUpload.clear();
                } else {
                    System.out.println("Empty for now");
                    hasPhotos.await();
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Photos uploaded");
    }

    public void onNewPhotoAdded(String path) {
        lock.lock();
        try {
            Thread.sleep(2000);
            photosToUpload.add(path);
            System.out.println("Photo added");
            hasPhotos.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
