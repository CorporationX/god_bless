package school.faang.sprint1.task_49024;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpLoad = new ArrayList<>();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpLoad.add(photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpLoad.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Что-то пошло не так");
                }
            }
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpLoad) {
            System.out.println("Загрузка фото " + photo);
        }
        photosToUpLoad.clear();
    }
}
