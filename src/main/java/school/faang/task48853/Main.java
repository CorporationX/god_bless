package school.faang.task48853;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUpload = new Thread(uploader::startAutoUpload);

        autoUpload.start();

        Thread addNewPhoto = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1");
                uploader.onNewPhotoAdded("photo2");
                uploader.onNewPhotoAdded(null);
                uploader.onNewPhotoAdded("");
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }
        });
        addNewPhoto.start();
    }
}
