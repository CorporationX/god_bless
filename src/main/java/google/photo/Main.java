package google.photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        Thread thread1 = new Thread(() -> googlePhotos.onNewPhotoAdded("Photo with Godzilla.png"));
        Thread thread2 = new Thread(googlePhotos::startAutoUpload);

        thread2.start();
        thread1.start();
    }
}
