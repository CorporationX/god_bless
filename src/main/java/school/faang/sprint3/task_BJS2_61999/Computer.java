package school.faang.sprint3.task_BJS2_61999;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Computer {
    private static final GooglePhotosAutoUploader GOOGLE_PHOTOS_AUTO_UPLOADER = new GooglePhotosAutoUploader();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final List<String> PATH_TO_PHOTOS = new ArrayList<>();
    private static final int COUNT_PHOTO = 20;

    public static void main(String[] args) {
        IntStream.range(0, COUNT_PHOTO).forEach(num -> addNewPhoto("Photo" + num));
        EXECUTOR.submit(GOOGLE_PHOTOS_AUTO_UPLOADER::startAutoUpload);

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
            log.error("Поток прерван", e);
        }

        GOOGLE_PHOTOS_AUTO_UPLOADER.printResult();
    }

    public static void addNewPhoto(String pathToPhoto) {
        PATH_TO_PHOTOS.add(pathToPhoto);
        EXECUTOR.submit(() -> GOOGLE_PHOTOS_AUTO_UPLOADER.onNewPhotoAdded(pathToPhoto));
    }
}
