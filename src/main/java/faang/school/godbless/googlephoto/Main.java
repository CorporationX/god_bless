package faang.school.godbless.googlephoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GooglePhoto googlePhoto = new GooglePhoto();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(googlePhoto);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> uploader.onNewPhotoAdded("new Photo"));
        executor.execute(uploader::startAutoUpload);
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
