package school.faang.googlephotosync.maincode;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            try {
                while (photosToUpload.isEmpty()) {
                    System.out.println("нет фотографий для загрузки, переходим в режим ожидания");
                    lock.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
            }
            uploadPhotos();
        }
    }

    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("загрузка фотографии  " + photo);
        }
        photosToUpload.clear();
        System.out.println("Все фотографии загружены");
    }
}
