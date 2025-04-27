package src.faang.BJS2_73729;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class GooglePhotosAutoUploader {
    private static final Object MONITOR = new Object();

    private static final Queue<String> photosToUpload = new ArrayDeque<>();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @SneakyThrows
    public void startAutoUpload() {
        synchronized (MONITOR) {
            while (photosToUpload.isEmpty()) {
                MONITOR.wait();
            }

            TimeUnit.SECONDS.sleep(random.nextInt(5));
            uploadPhotos();
            MONITOR.notify();
        }
    }

    @SneakyThrows
    public void onNewPhotoAdded(String photoPath) {
        synchronized (MONITOR) {
            log.info("New photo added: {}", photoPath);
            photosToUpload.add(photoPath);
            MONITOR.notify();
        }

        TimeUnit.SECONDS.sleep(random.nextInt(5));
    }

    private void uploadPhotos() {
        String poll = photosToUpload.poll();
        log.info("Photos uploaded: {}", poll);
    }
}
