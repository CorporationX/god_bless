package school.faang.googlephotosync.main;

import school.faang.googlephotosync.maincode.GooglePhotoAutoUploader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 2;
    public static void main(String[] args) {
        GooglePhotoAutoUploader photoAutoUploader = new GooglePhotoAutoUploader();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(photoAutoUploader::startAutoUpload);
        executor.submit(() -> {
            photoAutoUploader.oneNewPhotoAdded("fsdfsd");
            photoAutoUploader.oneNewPhotoAdded("nfsdknfk");
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
