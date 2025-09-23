package school.faang.bjs2_90393;

public class UserPhotoApp {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploader = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread photoAdder = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("jpg"));

        autoUploader.start();
        photoAdder.start();
    }
}
