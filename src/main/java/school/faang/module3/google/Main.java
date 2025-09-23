package school.faang.module3.google;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread t1 = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread t2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("/Documents/photo.jpg"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
