package faang.school.godbless.BJS2_5532;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(googlePhotos::startAutoUpload);
        executor.submit(() -> {
            googlePhotos.onNewPhotoAdded(List.of("path1", "path2"));
        });

        executor.submit(googlePhotos::startAutoUpload);
        executor.submit(() -> {
            googlePhotos.onNewPhotoAdded(List.of("path3", "path4"));
        });

        executor.shutdown();
    }
}
