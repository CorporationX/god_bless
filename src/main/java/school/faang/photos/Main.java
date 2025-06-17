package school.faang.photos;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        var uploader = new GooglePhotosAutoUploader();

        var uploadThread = new Thread(uploader::startAutoUpload, "AutoUploadThread");
        uploadThread.start();

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            final var j = i;
            var thread = new Thread(() -> uploader.onNewPhotoAdded("Photo %d".formatted(j)));
            threads.add(thread);
            thread.start();
        }

        for (var thread : threads) {
            tryJoin(thread);
        }

        tryJoin(uploadThread);
    }

    private static void tryJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} interrupted", Thread.currentThread().getName(), e.getCause());
        }
    }
}
