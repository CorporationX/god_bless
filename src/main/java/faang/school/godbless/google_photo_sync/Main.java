package faang.school.godbless.google_photo_sync;

public class Main {

    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();

        Thread uploadPhotos = new Thread(googlePhotos::startAutoUpload);

        Thread addPhotoPath = new Thread(() -> googlePhotos.onNewPhotoAdded("photo"));

        uploadPhotos.start();
        addPhotoPath.start();
    }
}
