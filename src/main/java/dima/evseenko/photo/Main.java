package dima.evseenko.photo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Uploading photos error", e);
            }
        });

        Thread addPhotosThread = new Thread(() -> uploader.onNewPhotoAdded("photo1", "photo2", "photo3"));

        uploadThread.start();
        addPhotosThread.start();
    }
}
