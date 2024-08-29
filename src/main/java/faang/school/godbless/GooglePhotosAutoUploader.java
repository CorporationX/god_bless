package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition newPhotoCondition = lock.newCondition();

    public void startAutoUpload() {
        lock.lock();
        try {
            while (true) {
                while (photosToUpload.isEmpty()) {
                    System.out.println("The photo list is empty, waiting for new photos to be added");
                    newPhotoCondition.await();
                }
                uploadPhotos();
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        } finally{
            lock.unlock();
        }
    }

    public void newPhotosAdded (String photoPath) {
        lock.lock();
        try {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            newPhotoCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void uploadPhotos() {
        System.out.println("Uploading photos...");
        for (String photo : photosToUpload) {
            System.out.println("Uploading: " + photo);
        }
        photosToUpload.clear();
        System.out.println("Finished uploading photos, list cleared");
    }
}