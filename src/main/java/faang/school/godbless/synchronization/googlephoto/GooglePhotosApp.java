package faang.school.godbless.synchronization.googlephoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglePhotosApp {

    public static void main(String[] args) {
        List<String> photos = new ArrayList<>(Arrays.asList("photo1", "photo2", "photo3", "photo4", "photo5", "photo6",
                "photo7", "photo8", "photo9", "photo10", "photo11", "photo12", "photo12"));
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        final Thread consumerThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            }
        });
        Thread supplierThread = new Thread(() -> {
            for (String photo : photos) {
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted");
                }
            }
        });
        consumerThread.start();
        supplierThread.start();
        while (true) {
            if (!supplierThread.isAlive()
                    && googlePhotosAutoUploader.getPhotosToUpload().isEmpty()) {
                consumerThread.interrupt();
                break;
            }
        }
    }

}
