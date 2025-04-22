package school.faang.sync.google_photos;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of("Photo 1", "Photo 2", "Photo 3", "Photo 4", "Photo 5", "Photo 6", "Photo 7");

        Thread photosUpload = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Thread of photos upload was interrupted");
            }
        });

        Thread photosAdd = new Thread(() -> {
            try {
                photos.forEach(uploader::onNewPhotoAdded);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Thread of adding photos was interrupted");
            }
        });

        photosUpload.start();
        photosAdd.start();

        try {
            photosAdd.join();
            photosUpload.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
