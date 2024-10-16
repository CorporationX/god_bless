package school.faang.photoSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        executor.submit(uploader::startAutoUpload);
        executor.submit(() -> {
            uploader.onNewPhotoAdded("C://DIR//firstPhotoPath.png");
            uploader.onNewPhotoAdded("C://DIR//secondPhotoPath.png");
        });
        executor.shutdown();
    }
}
