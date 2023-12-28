package Google;

public class PhotoLoader implements Runnable {

    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    public PhotoLoader(GooglePhotosAutoUploader googlePhotosAutoUploader) {
        this.googlePhotosAutoUploader = googlePhotosAutoUploader;
    }

    @Override
    public void run() {
        for (int times = 0; times < 4; times++) {
            for (int photos = 0; photos < 5; photos++) {
                googlePhotosAutoUploader.onNewPhotoAdded("Photo");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
