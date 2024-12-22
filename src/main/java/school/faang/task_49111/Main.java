package school.faang.task_49111;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread threadUpload = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread threadDownload = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("photo1");
            googlePhotosAutoUploader.onNewPhotoAdded("photo2"); });

        threadDownload.start();
        threadUpload.start();
    }
}
