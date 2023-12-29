package faang.school.godbless.google_photo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos(photosToUpload);
            }
        }
    }

    private void uploadPhotos() {
//        if (!photosToUpload.isEmpty()) {   Сначала сделал проверку, потом эту проверку убрал, сделал метод приватным чтобы он вызвался только из метода тогда проверка не нужна
        for (String photo : photosToUpload) {
            System.out.println("Начинается загрузка...");
            System.out.println("Идет загрузка фото..." + photo);
            System.out.println("Загрузка фото" + photo + " прошла успешно!!!");
        }
        photosToUpload.clear();
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

        executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded("www.google.com/phot/urheq123ijf"));

        if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}