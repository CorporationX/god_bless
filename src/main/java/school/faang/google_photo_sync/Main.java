package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread automaticUploaderThread = new Thread(uploader::startAutoLoad);
        Thread onNewPhotoAddedUploaderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        automaticUploaderThread.start();
        onNewPhotoAddedUploaderThread.start();
    }
}