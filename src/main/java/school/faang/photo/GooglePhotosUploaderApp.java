package school.faang.photo;

public class GooglePhotosUploaderApp {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("photo2.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        photoAdderThread.start();
    }
}
