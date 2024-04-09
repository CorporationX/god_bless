package faang.school.godbless.googlephotosync;

import java.util.Random;

public class Main {
    public static void main(String... args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addedPhotoThread = new Thread(() -> addedPhotos(uploader));

        uploadThread.start();
        addedPhotoThread.start();
    }

    private static void addedPhotos(GooglePhotosAutoUploader uploader) {
        while (true) {
            Random random = new Random();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            String photoPath = "photo" + random.nextInt(100) + ".jpg";
            uploader.onNewPhotoAdded(photoPath);
            System.out.println("Added new photo " + photoPath);
        }
    }
}
