package school.faang.sprint_3.task_43561;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < 10; i++) {
            executor.execute(uploader::startAutoUpload);
            executor.execute(() -> uploader.onNewPhotoAdded("Фото"));
        }

        executor.shutdown();
    }
}
