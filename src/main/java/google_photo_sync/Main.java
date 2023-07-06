package google_photo_sync;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("OnePhoto");
            autoUploader.onNewPhotoAdded("MyPhoto");
            autoUploader.onNewPhotoAdded("NotMyPhoto");
            autoUploader.startAutoUpload();
        });
        Thread viewThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<String> uploadedPhotos = autoUploader.getUploadedPhotos();
            System.out.println("Viewing uploaded photos: " + uploadedPhotos);
        });

        uploadThread.start();
        viewThread.start();

    }
}