package google_photo_sync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("PortraitPath");
            autoUploader.onNewPhotoAdded("LandscapePath");
            autoUploader.onNewPhotoAdded("Landscape2Path");
            autoUploader.startAutoUpload();
        });
        Thread viewThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                List<String> uploadedPhotos = autoUploader.getUploadedPhotos();
                System.out.println("Viewing uploaded photos: " + uploadedPhotos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        viewThread.start();

    }
}
