package school.faang.bjs2_90590;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println("Ожидаю фото");
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            System.out.println("Фото загружено на сервер");
            iterator.remove();
        }
    }
}
