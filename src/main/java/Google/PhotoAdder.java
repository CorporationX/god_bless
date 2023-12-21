package Google;

public class PhotoAdder implements Runnable {

    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    public PhotoAdder(GooglePhotosAutoUploader googlePhotosAutoUploader) {
        this.googlePhotosAutoUploader = googlePhotosAutoUploader;
    }

    @Override
    public void run() {
        while (true) {
            googlePhotosAutoUploader.onNewPhotoAdded("Photo");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
