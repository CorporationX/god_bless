package school.faang.stream3.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photosToUpload = List.of(
                "photo1", "photo2", "photo3", "photo4", "photo5", "photo6", "photo7", "photo8", "photo9"
        );
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            for (String photo : photosToUpload) {
                uploader.onNewPhotoAdded(photo);
                uploader.delay(100);
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            addPhotosThread.join();
            Object lock = uploader.getLock();
            synchronized (lock) {
                uploadThread.interrupt();
                lock.notify();
            }
        } catch (InterruptedException e) {
            log.error(String.format("Joining phase was interrupted %s", e.getMessage()));
        }
        System.out.println("main thread is over");
    }
}
