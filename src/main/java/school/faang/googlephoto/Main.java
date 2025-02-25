package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String pathPhoto = "newPath";
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread threadAutoUpload = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.error("Поток был прерван", e);
            }
        });
        try {
            Thread threadNewPhotoAdded = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(pathPhoto));
            threadAutoUpload.start();
            threadNewPhotoAdded.start();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        }
    }
}