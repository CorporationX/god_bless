package school.faang.thirdStream.BJS2_37169;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        lock = new Object();
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Нет новых фотографий для загрузки. Переход в режим ожидания...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Работа загрузчика была прервана");
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Добавлена новая фотография: " + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.printf("Загрузка фотографии %s на сервер%n", photo);
        }
        photosToUpload.clear();
        System.out.println("Загрузка фотографий завершена.\n");
    }
}
