package faang.school.godbless.module.third.synchronization.google;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();
    
    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int indexOfLast = photosToUpload.size() - 1;
                System.out.printf("Запустили автоаплоад, удаляем фото %s %n", photosToUpload.get(indexOfLast));
                photosToUpload.remove(indexOfLast);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    
    public void uploadPhotos() {
        synchronized (lock) {
            System.out.println("Выгружаем фотки в облако");
            photosToUpload.clear();
        }
    }
    
    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.printf("Добавили в список фото %s %n", photoPath);
            lock.notify();
        }
    }
}
