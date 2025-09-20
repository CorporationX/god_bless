package school.faang.bjs2_90412;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int THREAD_SLEEP_MILLIS = 1000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(() -> {
            int i = 1;
            while (true) {
                if (i % 10 == 0) {
                    Thread.sleep(THREAD_SLEEP_MILLIS);
                }
                String photoPath = "photo_" + i + ".webp";
                uploader.onNewPhotoAdded(photoPath);
                i++;
            }
        });

        executor.submit(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });
    }
}
