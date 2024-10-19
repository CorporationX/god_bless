package school.faang.googlephoto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@AllArgsConstructor
@Log4j2
public class GooglePhotosAutoUploader {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private List<String> photosToUpload;

    public void startAutoUpload() {
        lock.lock();
        try {
            while (photosToUpload.isEmpty()) {
                condition.await();
                System.out.println("Awaiting new photo...");
            }
            uploadPhotos();
        } catch (InterruptedException e) {
            log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
            throw new IllegalStateException("Thread" + Thread.currentThread().getName() + "was interrupted", e);
        } finally {
            lock.unlock();
        }
    }

    public void uploadPhotos() {
        photosToUpload = photosToUpload
                .stream()
                .peek(path -> System.out.println("photo with path: " + path + " was upload"))
                .filter(photo -> false)
                .collect(Collectors.toList());
    }

    public void onNewPhotoAdded(String photoPath) {
        lock.lock();
        try {
            photosToUpload.add(photoPath);
            System.out.println("Photo " + photoPath + " was added to awaiting list");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
