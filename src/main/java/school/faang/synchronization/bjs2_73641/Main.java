package school.faang.synchronization.bjs2_73641;

public class Main {
    private static final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    public static void main(String[] args) {
        Thread uploadsPhotos = new Thread(uploader::startAutoUpload);
        Thread addsPhotoPaths = new Thread(() -> {
            uploader.onNewPhotoAdded("path/1");
            uploader.onNewPhotoAdded("path/2");
        });

        addsPhotoPaths.start();
        uploadsPhotos.start();
    }
}
