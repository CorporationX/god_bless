package google_photo_sync;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final Lock lock = new ReentrantLock();
    private final List<String> photosToUpload = new ArrayList<>();
    private final List<String> uploadedPhotos = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void onNewPhotoAdded(String pathToPhoto) {
        synchronized (lock) {
            photosToUpload.add(pathToPhoto);
            lock.notify();
        }
    }

    public List<String> getUploadedPhotos() {
        synchronized (lock) {
            return new ArrayList<>(uploadedPhotos);
        }
    }

    private void uploadPhotos() {
        for (String path : photosToUpload) {
            System.out.println("Uploading photo " + path);
            uploadedPhotos.add(path);
        }
        photosToUpload.clear();
    }
}
