package school.faang.googlephoto;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {

        List<String> photosToUpload = new ArrayList<>(List.of("photo1", "photo2"));
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photosToUpload);

        Thread uploadThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
                    System.out.println("Thread uploadThread was interrupted");
                }
            }
        });

        Thread addPhotosThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    String newPhotoPath = "photo_" + i + ".jpg";
                    uploader.onNewPhotoAdded(newPhotoPath); // Add new photo
                    System.out.println("Added new photo: " + newPhotoPath);
                    Thread.sleep(3000); // Simulate delay before adding another photo
                }
            } catch (InterruptedException e) {
                log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
                throw new IllegalStateException("Thread" + Thread.currentThread().getName() + "was interrupted", e);
            }
        });

        uploadThread.start();
        addPhotosThread.start();
        try {
            addPhotosThread.join();
            Thread.sleep(3000);
            uploadThread.interrupt();
            uploadThread.join();
        } catch (InterruptedException e) {
            log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
            throw new IllegalStateException("Thread" + Thread.currentThread().getName() + "was interrupted", e);
        }
        System.out.println("Main thread finished.");
    }
}
