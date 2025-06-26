package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadPhoto = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("Photo: " + i);
            }
        });
        uploadPhoto.start();
        addPhoto.start();
        uploadPhoto.join();
        addPhoto.join();
    }
}