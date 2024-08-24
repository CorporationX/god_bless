package faang.school.godbless.googlephotosync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });
        uploadThread.start();
        addPhotoThread.start();
        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}