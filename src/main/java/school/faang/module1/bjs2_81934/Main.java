package school.faang.module1.bjs2_81934;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(new ArrayList<>());
        List<String> folderPhotos = List.of(
                "photo1.jpg", "photo2.jpg", "photo3.jpg",
                "photo4.jpg", "photo5.jpg", "photo6.jpg"
        );
        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addingThread = new Thread(() -> addPhotos(googlePhotosAutoUploader, folderPhotos));
        uploadThread.start();
        addingThread.start();
        try {
            addingThread.join();
            googlePhotosAutoUploader.stop();
            uploadThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
        }
    }

    private static void addPhotos(GooglePhotosAutoUploader uploader, List<String> photos) {
        for (String photo : photos) {
            uploader.onNewPhotoAdded(photo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван", e);
            }
        }
    }
}