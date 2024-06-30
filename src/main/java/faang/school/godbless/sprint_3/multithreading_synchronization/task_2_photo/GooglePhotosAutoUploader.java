package faang.school.godbless.sprint_3.multithreading_synchronization.task_2_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    public static final Object lock = new Object();
    public static final List<String> photosToUpload = new ArrayList<>();
    private boolean isActive = true;

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    System.out.printf("%s: ждёт фоток.\n", Thread.currentThread().getName());
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.printf("%s: добавляет путь %s в очередь на загрузку.\n", Thread.currentThread().getName(), photoPath);
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        System.out.printf("%s: начал загружать фото на сервер.\n", Thread.currentThread().getName());
        for (int i = 0; i < photosToUpload.size(); i++) {
            System.out.printf("\tupload \"%s\" & remove from list\n", photosToUpload.remove(i));
        }
    }
    public synchronized void setOff() {
        isActive = !isActive;
    }

    public synchronized boolean isActive() {
        return isActive;
    }
}
