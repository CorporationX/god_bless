package school.faang.stream3.synchronization.googlephotosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
            }
        });
        executor.execute(uploader::startAutoUpload);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
