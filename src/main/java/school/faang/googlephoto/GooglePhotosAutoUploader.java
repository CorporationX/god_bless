package school.faang.googlephoto;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GooglePhotosAutoUploader {

    private ReentrantLock lock;
    //private final Condition notEmpty = lock.newCondition();

    private List<String> photosToUpload;


    public void startAutoUpload() {
        lock.lock();
        try {
            while (photosToUpload.isEmpty()) {
                lock.newCondition().await();
            }
            uploadPhotos();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
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
            lock.newCondition().signal();
        } finally {
            lock.unlock();
        }
    }
}
