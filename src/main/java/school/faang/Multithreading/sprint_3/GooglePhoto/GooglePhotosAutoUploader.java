package school.faang.Multithreading.sprint_3.GooglePhoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Список на отправку пуст: " + photosToUpload);
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Операция была прервана" + e.getMessage());
                    e.printStackTrace();
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        System.out.println("Фотографии загружаются на сервер:" + photosToUpload);
        photosToUpload.clear();
        System.out.println("Фотографии загружены на сервер и удалены локально:" + photosToUpload);
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
            lock.notify();
        }
    }
}
