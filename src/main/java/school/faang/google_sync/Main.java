package school.faang.google_sync;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread starter = new Thread(() -> uploader.startAutoUpload());
        Thread adder = new Thread(() -> uploader.onNewPhotoAdded("new Photo"));
        starter.start();
        adder.start();
    }
}
