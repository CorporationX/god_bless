package faang.school.godbless.BJS2_24521;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {

    private List<String> photosToUpload = new ArrayList<>();

    private final Object lock = new Object();

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлен путь к фото");
            lock.notify();
        }
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            System.out.println("Фото загружено на сервер");
        }
    }
}
