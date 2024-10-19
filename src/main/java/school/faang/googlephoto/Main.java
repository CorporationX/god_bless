package school.faang.googlephoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        List<String> photosToUpload = new ArrayList<>();//(List.of("photo1", "photo2"));

           GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(lock, photosToUpload);

               Thread uploadThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Upload thread interrupted.");
                    break;
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
                Thread.currentThread().interrupt();
                System.out.println("Adding photos thread interrupted.");
            }
        });

        // Start both threads
        uploadThread.start();
        addPhotosThread.start();

        // Wait for both threads to finish
        addPhotosThread.join();
        uploadThread.interrupt(); // Interrupt the upload thread after adding photos

        System.out.println("Main thread finished.");
    }
}
