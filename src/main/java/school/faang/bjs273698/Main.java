package school.faang.bjs273698;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int WAITING_TIME = 5000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread firstAddThread = new Thread(() -> uploader.onNewPhotoAdded("Photo 1"));
        firstAddThread.start();

        Thread secondAddThread = new Thread(() -> uploader.onNewPhotoAdded("Photo 2"));
        secondAddThread.start();

        Thread thirdAddThread = new Thread(() -> uploader.onNewPhotoAdded("Photo 3"));
        thirdAddThread.start();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        try {
            Thread.sleep(WAITING_TIME);
            uploadThread.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
