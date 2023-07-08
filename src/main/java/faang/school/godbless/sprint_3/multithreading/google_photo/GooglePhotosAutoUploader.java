package faang.school.godbless.sprint_3.multithreading.google_photo;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {
    private final Lock lock = new ReentrantLock();
    private final List<String> photosToUpload = List.of("D:\\Java\\second\\text.txt",
            "D:\\Java\\second\\text2.txt",
            "D:\\Java\\second\\text3.txt");

    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }


    public void oneNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    @SneakyThrows
    private void uploadPhotos() {
        System.out.println("Загружаем фотографии на сервер....");
        Thread.sleep(1000);
        photosToUpload.clear();
    }
}
