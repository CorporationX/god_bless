package google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread thread1 = new Thread(() ->googlePhotosAutoUploader.onNewPhotoAdded("photo1.img"));
        Thread thread2 = new Thread(googlePhotosAutoUploader::startAutoUpload);

        thread2.start();
        thread1.start();
    }
}
