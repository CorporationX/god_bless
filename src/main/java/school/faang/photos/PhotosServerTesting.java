package school.faang.photos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhotosServerTesting {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoPhotoUploader = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(() -> autoPhotoUploader.onNewPhotoAdded("someFilePath"));
        Thread photoAdder = new Thread(() -> {
            try {
                autoPhotoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.error("Поток был прерван");
                Thread.currentThread().interrupt();
            }
        });

        photoAdder.start();
        uploader.start();

    }
}
