package faang.school.godbless.google.photo;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread t1 = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread t2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Изображение"));

        t1.start();
        t2.start();
    }
}
