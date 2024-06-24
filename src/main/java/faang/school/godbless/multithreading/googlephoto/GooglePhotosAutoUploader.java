package faang.school.godbless.multithreading.googlephoto;

import java.util.LinkedList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {
        synchronized(lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println("Метод старта загрузки ждёт");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Метод старта загрузки проснулся");
            uploadPhotos();
        }
    }

    public void uploadPhotos() {
        synchronized(lock) {
            while (!photosToUpload.isEmpty()) {
                String path = photosToUpload.get(photosToUpload.size() - 1);
                System.out.println("Обработано фото: " + path);
                photosToUpload.remove(photosToUpload.size() - 1);
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized(lock) {
            System.out.println("Запустился метод добавления пути");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

}
