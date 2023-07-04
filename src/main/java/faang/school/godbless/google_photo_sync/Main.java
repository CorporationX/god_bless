package faang.school.godbless.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread watchThread = new Thread(() -> {
            googlePhoto.onNewPhotoAdded("original.jpeg");
            System.out.println(googlePhoto.getPhotosToUpload());
        });
        Thread downloadThread = new Thread(() -> googlePhoto.startAutoUpload());

        watchThread.start();
        downloadThread.start();
    }
}
