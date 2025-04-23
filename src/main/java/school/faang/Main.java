package school.faang;

import school.faang.photo_sync.GooglePhotosAutoUploader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> pathes = List.of("path1", "path2", "path3", "path4", "path5", "path6");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (String path : pathes) {
            executor.execute(() -> uploader.onNewPhotoAdded(path));
            executor.execute(uploader::startAutoUpload);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("End of execution");
    }

}
