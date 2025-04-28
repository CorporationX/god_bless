package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread addPhotosThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotosAdded("new photo 1");
            googlePhotosAutoUploader.onNewPhotosAdded("new photo 2");
        });

        uploaderThread.start();
        addPhotosThread.start();
    }
}
