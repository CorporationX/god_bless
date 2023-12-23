package faang.school.godbless.google_photo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class GooglePhotosAutoUploader {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        String photoPath = "www.google.com/phot/urheq123ijf";

        List<String> photosToUpload = List.of("1.png", "2.png", "3.png", "4.png", "5.png", "6png",
                "7.png", "8.png", "9.png", "10.png", "11.png", "12.png", "13.png", "14.png", "15.png");

        executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(photoPath));

        executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload(photosToUpload);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }


    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(List<String> photos) throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photos.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos(photos);
            }
        }
    }

    private void uploadPhotos(List<String> photosToUpload) {
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
}