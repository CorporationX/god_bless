package school.faang.sprint3.task48998google;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        String photoPath = "path";
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread autoUpload = new Thread(
                () -> {
                    try {
                        googlePhoto.startAutoUpload();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        Thread photoAdded = new Thread(
                () -> googlePhoto.onNewPhotoAdded(photoPath)
        );

        autoUpload.start();
        photoAdded.start();
    }
}
