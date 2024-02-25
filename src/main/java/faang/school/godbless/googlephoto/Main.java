package faang.school.godbless.googlephoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_COUNTS = 2;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNTS);

        executor.execute(() -> uploader.onNewPhotoAdded("new Photo"));
        executor.execute(uploader::startAutoUpload);

        executor.shutdown();
        awaitTermination(executor, 5L);
    }

    private static void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
