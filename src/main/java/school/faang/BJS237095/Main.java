package school.faang.BJS237095;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL = 2;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(List.of(
                "/download/photo.jpg",
                "/download/photo2.jpg",
                "/download/photo3.jpg",
                "/download/photo4.jpg",
                "/download/photo5.jpg"));
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);
        service.submit(uploader::startAutoUpload);
        service.submit(() -> {
            uploader.onNewPhotoAdded("/download/logo.png");
            uploader.onNewPhotoAdded("/download/logo2.png");
            uploader.onNewPhotoAdded("/download/logo3.png");
        });

        service.shutdown();
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Потоки не закончились!");
            } else {
                System.out.println("Потоки завершены!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
