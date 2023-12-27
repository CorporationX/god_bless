package Google;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        PhotoLoader photoLoader = new PhotoLoader(googlePhotosAutoUploader);

        Thread photoLoaderThread = new Thread(photoLoader);
        Thread photoUploaderThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        photoLoaderThread.start();
        photoUploaderThread.start();
    }
}
