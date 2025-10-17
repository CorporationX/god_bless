package school.faang.sprint3.photo.uploader;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Queue;

@RequiredArgsConstructor
public class GooglePhotosAutoUploader {

    private final Queue<String> photosToUpload;

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            if (!photosToUpload.isEmpty()) {
                uploadPhotos();
            } else {
                try {
                    System.out.println("Нет фото для выгрузки");
                    photosToUpload.wait();
                    System.out.println("Загрузка продолжается");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Ошибка ожидания фото");
                }
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.printf("Добавлено фото %s. Уведомление потоков\n", photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            Optional.ofNullable(photosToUpload.poll()).ifPresent(
                    uploadedPhoto -> System.out.printf("Выгружено изображение %s\n", uploadedPhoto)
            );
        }
    }
}
