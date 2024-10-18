package school.faang.Multithreading.sprint_3.GooglePhoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhotoUploadApp {
    public static int POOL_SiZE = 2;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SiZE);

        executor.execute(uploader::startAutoUpload);

        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                uploader.onNewPhotoAdded("Photo Path " + i);
            }
        });

        executor.shutdown();
    }
}
