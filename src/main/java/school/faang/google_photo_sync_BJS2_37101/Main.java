package school.faang.google_photo_sync_BJS2_37101;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread threadUploader = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread threadAdder = new Thread(() ->
                googlePhotosAutoUploader.oneNewPhotoAdded("C:/photos/vacation/photo3.jpg"));

        threadUploader.start();
        threadAdder.start();
    }
}
