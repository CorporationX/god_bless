package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread automaticUploaderThread = new Thread(uploader::startAutoLoad);
        Thread onNewPhotoAddedUploaderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread has been interrupted: " + e.getMessage());
            }
            uploader.onNewPhotoAdded("photo2.jpg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread has been interrupted: " + e.getMessage());
            }
            uploader.onNewPhotoAdded("photo3.jpg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread has been interrupted " + e.getMessage());
            }
            uploader.onNewPhotoAdded("photo4.jpg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread has been interrupted " + e.getMessage());
            }
            uploader.onNewPhotoAdded("photo5.jpg");
        });
        automaticUploaderThread.start();
        onNewPhotoAddedUploaderThread.start();
    }
}