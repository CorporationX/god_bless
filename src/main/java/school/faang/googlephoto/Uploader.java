package school.faang.googlephoto;

public class Uploader {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(autoUploader::startAutoUpload);
        uploaderThread.start();

        Thread adderThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("photo1");
            autoUploader.onNewPhotoAdded("photo2");
        });
        adderThread.start();
    }
}
