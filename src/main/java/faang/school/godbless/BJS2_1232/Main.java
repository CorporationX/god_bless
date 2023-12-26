package faang.school.godbless.BJS2_1232;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photoPaths = List.of("C:/somepath/one_photo.jpg", "C:/somepath/two_photo.jpg", "C:/somepath/three_photo.jpg", "C:/somepath/four_photo.jpg");
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(photosAutoUploader::startAutoUpload);
        Thread watchThread = new Thread(() -> {
            watchForNewPhotos(photoPaths, photosAutoUploader);
        });

        uploadThread.start();
        watchThread.start();
    }

    private static void watchForNewPhotos(List<String> photoPaths, GooglePhotosAutoUploader photosAutoUploader) {
        for (String photoPath : photoPaths) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosAutoUploader.onNewPhotoAdded(photoPath);
        }
    }
}