package BJS2_24401_GooglePhotoSync;

public class Application {
    private static final int PHOTO_TO_UPLOAD = 10;

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread getPhotos = new Thread(() -> {
            for (int i = 0; i < PHOTO_TO_UPLOAD; i++) {
                try {
                    Thread.sleep(1000);
                    googlePhotosAutoUploader.onNewPhotoAdded("photo " + (i + 1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploadThread.start();
        getPhotos.start();
    }
}
