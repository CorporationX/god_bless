package school.faang;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread threadUpload1 = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread threadUpload2 = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread threadAdd1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("c"));
        Thread threadAdd2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("e"));
        threadUpload1.start();
        threadUpload2.start();
        threadAdd1.start();
        threadAdd2.start();

    }

}