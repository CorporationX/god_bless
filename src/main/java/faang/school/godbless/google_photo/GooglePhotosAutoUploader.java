package faang.school.godbless.google_photo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Начинается загрузка из списка ...");
                System.out.println("Идет загрузка фото..." + photo);
                System.out.println("Загрузка фото" + photo + " прошла успешно!!!");
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото " + photoPath + " успешно добавлено в список ...");
            lock.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        List<String> photos = List.of(
                "1111111111",
                "2222222222",
                "3333333333",
                "4444444444",
                "5555555555"
        );

        Future<?> added = executorService.submit(() -> {
            for (String photo : photos) {
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
            }
        });

        Future<?> autoLoading = executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
        while (true) {
            if (added.isDone() && googlePhotosAutoUploader.photosToUpload.isEmpty()) {
                autoLoading.cancel(true);
                break;
            }
        }
    }
}