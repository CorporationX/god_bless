package school.faang.sprint3.multithreading.bjs2_61970;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Object lock = new Object();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                System.out.print("\nThe photo list is empty.");
                lock.wait();
            }
            uploadPhotos();
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
