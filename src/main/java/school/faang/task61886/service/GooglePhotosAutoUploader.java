package school.faang.task61886.service;

import lombok.Getter;

import java.util.List;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = List.of(
            "C:\\Users\\drogulkin\\Pictures1",
            "C:\\Users\\drogulkin\\Pictures2",
            "C:\\Users\\drogulkin\\Pictures3",
            "C:\\Users\\drogulkin\\Pictures4"
    );

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Какая то ошибка: " + e);
                }
            }
            uploadPhotos();
        }
    }

    private void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }
}
