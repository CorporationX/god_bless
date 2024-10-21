package faang.school.godbless.mt.google;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int UPLOAD_PHOTO_DELAY = 1000;
    private static final int ADD_PHOTO_DELAY = 1500;
    private static final int COMMON_TIMEOUT = 20000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread t1 = createThreadForUpload(uploader);
        Thread t2 = createThreadForAddNewPhoto(uploader);
        t1.start();
        t2.start();

        try {
            Thread.sleep(COMMON_TIMEOUT);
            t1.interrupt();
            t2.interrupt();
            log.info("Finish");
            Thread.sleep(COMMON_TIMEOUT); // Убедиться, что все потоки завершились
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Thread createThreadForUpload(GooglePhotosAutoUploader uploader) {
        return new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    uploader.startAutoUpload();
                    Thread.sleep(UPLOAD_PHOTO_DELAY);
                } catch (InterruptedException e) {
                    log.warn("Thread is interrupted");
                    var t = Thread.currentThread();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    private static Thread createThreadForAddNewPhoto(GooglePhotosAutoUploader uploader) {
        return new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                uploader.onNewPhotoAdded("path");
                try {
                    Thread.sleep(ADD_PHOTO_DELAY);
                } catch (InterruptedException e) {
                    log.warn("Thread is interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
