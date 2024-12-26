package school.faang.bjs248997;

public class ServerGooglePhotos implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    public ServerGooglePhotos(GooglePhotosAutoUploader googlePhotosAutoUploader) {
        this.googlePhotosAutoUploader = googlePhotosAutoUploader;
    }

    @Override
    public void run() {
        try {
            googlePhotosAutoUploader.startAutoUpload();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " is interrupt. Thread end work");
        }
    }
}
