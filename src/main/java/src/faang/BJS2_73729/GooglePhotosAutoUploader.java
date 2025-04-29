package src.faang.BJS2_73729;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class GooglePhotosAutoUploader {
    private static final Queue<String> photosToUpload = new ArrayDeque<>();
    private static final int RANDOM_BOUND_FOR_SLEEPING = 5;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @SneakyThrows
    public synchronized void startAutoUpload() {
        while (photosToUpload.isEmpty()) {
            wait();
        }

        TimeUnit.SECONDS.sleep(random.nextInt(RANDOM_BOUND_FOR_SLEEPING));
        uploadPhotos();
    }

    @SneakyThrows
    public void onNewPhotoAdded(String photoPath) {
        synchronized (this) {
            log.info("New photo added: {}", photoPath);
            photosToUpload.add(photoPath);
            notify();
        }

        TimeUnit.SECONDS.sleep(random.nextInt(RANDOM_BOUND_FOR_SLEEPING));
    }

    private void uploadPhotos() {
        String poll = String.join(", ", photosToUpload);
        log.info("Photos uploaded: {}", poll);
        photosToUpload.clear();
    }
}
