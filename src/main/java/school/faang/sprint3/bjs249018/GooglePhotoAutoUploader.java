package school.faang.sprint3.bjs249018;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = Stream.of("C:/photos/001.jpg", "C:/photos/002.jpg")
            .collect(Collectors.toList());

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.err.println("Ошибка при ожидании потока: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Непредвиденная ошибка: " + e.getMessage());
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото '" + photoPath + "' было добавлено на устройство.");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Фото '" + photo + "' загружено.");
            }
            System.out.println("Все фотографии успешно загружены на сервер.");
            photosToUpload.clear();
            System.out.println("Фотографии удалены с устройства.\n");
        }
    }
}