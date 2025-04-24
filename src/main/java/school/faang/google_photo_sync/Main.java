package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread addThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("Photo1");
            autoUploader.onNewPhotoAdded("Photo2");
            autoUploader.onNewPhotoAdded("Photo3");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            autoUploader.onNewPhotoAdded("Photo4");
            autoUploader.onNewPhotoAdded("Photo5");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            autoUploader.onNewPhotoAdded("Photo6");
        });

        Thread loadThread = new Thread(() -> {
            try {
                autoUploader.startAutoUpload();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        });

        loadThread.start();
        addThread.start();
    }
}
