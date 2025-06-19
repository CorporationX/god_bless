package school.faang.bjs2_81921_google_photos_upload;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class GoogleApp {
    public static final int MAX_PHOTO_CREATION_DELAY_MS = 10000;

    public static void main(String[] args) {
        List<String> oldPhotos = new ArrayList<>(List.of(
                "/docs/photos/IMG_1222.jpg",
                "/docs/photos/IMG_1221.jpg",
                "/docs/photos/IMG_1223.jpg",
                "/docs/photos/IMG_1225.jpg",
                "/docs/photos/IMG_1226.jpg",
                "/docs/photos/IMG_1229.jpg"
        ));

        GooglePhotosAutoUploader uploaderService = new GooglePhotosAutoUploader(oldPhotos);
        Thread uploaderThread = getUploaderThread(uploaderService);

        List<String> newPhotos = new ArrayList<>(List.of(
                "/docs/photos/IMG_2222.jpg",
                "/docs/photos/IMG_2221.jpg",
                "/docs/photos/IMG_2223.jpg",
                "/docs/photos/IMG_2225.jpg",
                "/docs/photos/IMG_2226.jpg",
                "/docs/photos/IMG_2229.jpg"
        ));

        Thread additionThread = getAdditionThread(uploaderService, newPhotos);

        uploaderThread.start();
        additionThread.start();
    }

    private static Thread getAdditionThread(GooglePhotosAutoUploader uploaderService, List<String> newPhotos) {
        return new Thread(() -> {
            while (!newPhotos.isEmpty()) {
                log.info("Adding new photo {}", newPhotos.get(0));
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1, MAX_PHOTO_CREATION_DELAY_MS));
                    uploaderService.onNewPhotoAdded(newPhotos.get(0));
                    newPhotos.remove(0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            log.info("No more photos for today. Requesting graceful shutdown of uploader service.");
            uploaderService.gracefulShutdown();
        });
    }

    private static Thread getUploaderThread(GooglePhotosAutoUploader uploaderService) {
        return new Thread(() -> {
            try {
                uploaderService.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }
}
