package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadPhoto = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Photo"));
        uploadPhoto.start();
        addPhoto.start();
    }
}
