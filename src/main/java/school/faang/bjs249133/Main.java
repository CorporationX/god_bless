package school.faang.bjs249133;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(autoUploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("photo1.jpg");
            autoUploader.onNewPhotoAdded("photo2.jpg");
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}
