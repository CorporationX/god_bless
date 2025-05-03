package school.faang.google_photo_sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader1 = new GooglePhotosAutoUploader("Uploader-1");
        GooglePhotosAutoUploader uploader2 = new GooglePhotosAutoUploader("Uploader-2");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(uploader1::startAutoUpload);
        executorService.submit(uploader2::startAutoUpload);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                uploader1.onNewPhotoAdded("image1.jpg");
                TimeUnit.SECONDS.sleep(2);
                uploader1.onNewPhotoAdded("image2.jpg");
                TimeUnit.SECONDS.sleep(1);
                uploader2.onNewPhotoAdded("image3.jpg");
                TimeUnit.SECONDS.sleep(2);
                uploader2.onNewPhotoAdded("image4.jpg");
                TimeUnit.SECONDS.sleep(3);
                uploader1.onNewPhotoAdded("image5.jpg");
            } catch (InterruptedException e) {
                log.error("Поток добавления фотографий прерван", e);
                Thread.currentThread().interrupt();
            }
        }).start();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}