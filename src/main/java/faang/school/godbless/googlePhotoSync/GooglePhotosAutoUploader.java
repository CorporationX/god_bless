package faang.school.godbless.googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload( ) throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos () {
        photosToUpload.stream().forEach(photo -> System.out.println("Файл загружен в Gogle Photo:" + photo));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено, путь: " + photoPath);
            lock.notify();
        }
    }
}