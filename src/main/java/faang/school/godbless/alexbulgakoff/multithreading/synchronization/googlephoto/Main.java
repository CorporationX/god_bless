package faang.school.godbless.alexbulgakoff.multithreading.synchronization.googlephoto;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        String photo1 = "photo1";
        String photo2 = "photo2";
        String photo3 = "photo3";

        googlePhotosAutoUploader.onNewPhotoAdded(photo1);
        googlePhotosAutoUploader.onNewPhotoAdded(photo2);
        googlePhotosAutoUploader.onNewPhotoAdded(photo3);

        Thread uploadPhotos = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread viewPhotos = new Thread(googlePhotosAutoUploader::viewPhoto);

        uploadPhotos.start();
        viewPhotos.start();
    }
}
