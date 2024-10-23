package gmail.photo.sync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();


    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаю фотографию: " + photo);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
                System.out.println("Поток загрузки фотографии прерван");
            }
        }
        photosToUpload.clear();
        System.out.println("Загрузка завершена");
    }

    public void oneNewPhotoAdded(String path) {
        synchronized (lock) {
            photosToUpload.add(path);
            System.out.println("В хранилище добавлена новая фотография: " + path);
            lock.notify();
        }
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Источник загрузки фотографий пуст. Ожидаем новых... ");
                    lock.wait();
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток автозагрузки прерван");

                }
            }
            uploadPhotos();
        }
    }
}
