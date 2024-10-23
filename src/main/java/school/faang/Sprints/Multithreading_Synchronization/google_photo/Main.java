package school.faang.Sprints.Multithreading_Synchronization.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread threadUpload1 = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread threadUpload2 = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread threadAdd1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Photo1"));
        Thread threadAdd2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Photo2"));
        threadUpload1.start();
        threadUpload2.start();
        threadAdd1.start();
        threadAdd2.start();

    }

}