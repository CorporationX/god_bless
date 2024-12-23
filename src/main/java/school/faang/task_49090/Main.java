package school.faang.task_49090;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(googlePhotos::startAutoUpload);
        uploader.start();
        Thread adder;
        adder = new Thread(() -> {
            googlePhotos.onNewPhotoAdded("Photo1 path");
            googlePhotos.onNewPhotoAdded("Photo2 path");
        });
        adder.start();
    }
}
