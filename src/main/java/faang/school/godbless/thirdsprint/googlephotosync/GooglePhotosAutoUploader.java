package faang.school.godbless.thirdsprint.googlephotosync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    public static final int WAIT_TIME = 10;
    public static final int UPLOAD_TIME = 750;

    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                try {
                    while (photosToUpload.isEmpty()) {
                        System.out.println("Нет новых фотографий, ожидание...");
                        lock.wait(WAIT_TIME * 1000);

                        if (photosToUpload.isEmpty()) {
                            System.out.println("Загрузка прервана из-за отсутствия" +
                                    " новых фотографий в течение 10 секунд.");
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
        String photo = photosToUpload.remove(0);
        System.out.println("Загрузка фотографии: " + photo);
        try {
            Thread.sleep(UPLOAD_TIME);
        } catch (InterruptedException e) {
            System.out.println("Процесс загрузки прерван.");
            throw new RuntimeException(e);
        }
        System.out.println("Фотография загружена: " + photo);
    }
}
