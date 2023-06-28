package faang.school.godbless.Multitrading2.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(() -> uploader.onNewPhotoAdded("C/Desktop/Photos"));
        service.execute(uploader::startAutoUpload);
        service.execute(() -> uploader.onNewPhotoAdded("C/Desktop/Photos"));
        service.execute(() -> uploader.onNewPhotoAdded("C/Desktop/Photos"));
        service.execute(() -> uploader.onNewPhotoAdded("C/Desktop/Photos"));
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(photo -> {
                System.out.println(photo + " Uploaded");
            });
            photosToUpload = new ArrayList<>();
        }
    }
}
