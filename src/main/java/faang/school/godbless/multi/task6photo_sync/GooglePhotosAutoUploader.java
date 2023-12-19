package faang.school.godbless.multi.task6photo_sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Загрузка прервана");
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
        synchronized (lock) {
            if (!photosToUpload.isEmpty()) {
                for (String photo : photosToUpload) {
                    try {
                        System.out.println("Загружается фото: " + photo);
                        Thread.sleep(2000);
                        System.out.println("Загрузилось фото: " + photo);
                    } catch (InterruptedException e) {
                        System.out.println("Загрузка прервана");
                    }
                }
                photosToUpload.clear();
            }
        }
    }
}
