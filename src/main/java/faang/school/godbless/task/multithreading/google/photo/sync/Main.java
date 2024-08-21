package faang.school.godbless.task.multithreading.google.photo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int SCHEDULER_TIMER = 5;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

    public static void main(String[] args) {
        var pathToPhotos = List.of(
                "/disc/images/Photo_1",
                "/disc/images/Photo_2",
                "/disc/images/Photo_3",
                "/disc/images/Photo_4",
                "/disc/images/Photo_5",
                "/disc/images/Photo_6",
                "/disc/images/Photo_7",
                "/disc/images/Photo_8"
        );
        Thread uploadPhoto = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            pathToPhotos.forEach(googlePhotosAutoUploader::onNewPhotoAdded);
        });
        uploadPhoto.start();
        addPhoto.start();
        executeStopUpload();
        try {
            uploadPhoto.join();
            addPhoto.join();
        } catch (InterruptedException e) {
            log.error("Interrupted exception: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        log.info("Программа завершена");
    }

    private static void executeStopUpload() {
        scheduler.schedule(() -> {
            googlePhotosAutoUploader.stopAutoUpload();
            scheduler.shutdown();
        }, SCHEDULER_TIMER, TimeUnit.SECONDS);
    }
}
