package school.faang.task_49036;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            int number = i;
            executor1.submit(() -> {
                uploader.onNewPhoto("Photo #-" + number);
            });
        }


        for (int i = 0; i < 20; i++) {
            int number = i;
            executor2.submit(() -> {
                try {
                    uploader.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor1.shutdown();
        executor2.shutdown();
    }
}