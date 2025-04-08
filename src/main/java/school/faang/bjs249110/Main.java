package school.faang.bjs249110;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread photoAdderThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(100);
                    uploader.onNewPhotoAdded("photo" + i + ".jpg");
                }
            } catch (InterruptedException e) {
                log.error("Photo adder thread was interrupted");
                Thread.currentThread().interrupt();
            }
        });
        uploadThread.start();
        photoAdderThread.start();

        try {
            uploadThread.join();
            photoAdderThread.join();
        } catch (Exception e) {
            log.error("Main thread interrupted.", e);
            Thread.currentThread().interrupt();
        }
    }
}