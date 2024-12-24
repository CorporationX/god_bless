package school.faang.sprint4.task2;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhotosAutoUploader {
    private final Queue<String> photosToUpload = new LinkedList<>();
    private final Object lock = new Object();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
