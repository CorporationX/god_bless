package school.faang.module3.google.photo;

public class GooglePhotoService {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploaderManager = new GooglePhotosAutoUploader();
        Thread uploader = new Thread(autoUploaderManager::startAutoUpload);
        uploader.start();
        Thread adder = new Thread(() -> autoUploaderManager.onNewPhotoPath("/path/to/file/nature.png"));
        adder.start();

        try {
            uploader.join();
            adder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
