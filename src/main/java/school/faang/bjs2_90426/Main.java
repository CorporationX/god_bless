package school.faang.bjs2_90426;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final long TASK_DURATION = 1L;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> uploader.startAutoUpload());

        Thread photoAdderThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(TASK_DURATION);
                uploader.onNewPhotoAdded("photo1.jpg");
                uploader.onNewPhotoAdded("photo2.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}