package school.faang.googlephoto;

public class GooglePhotoService {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread photoAdderThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("SKA-game.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("Markizka.jpg");
        });
        uploaderThread.start();
        photoAdderThread.start();
    }
}
