package school.faang.photosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();
    List<String> server = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted");
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photosToUpload1 : photosToUpload) {
            System.out.println("Загружается фотография на сервер " + photosToUpload1);
            server.add(photosToUpload1);
            System.out.println("На сервере теперь есть " + photosToUpload1);
        }
        photosToUpload.clear();
    }
}

