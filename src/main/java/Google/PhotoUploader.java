package Google;

public class PhotoUploader implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    public PhotoUploader(GooglePhotosAutoUploader googlePhotosAutoUploader) {
        this.googlePhotosAutoUploader = googlePhotosAutoUploader;
    }

    @Override
    public void run() {
        while (true) {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
