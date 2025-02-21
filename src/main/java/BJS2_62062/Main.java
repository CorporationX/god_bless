package BJS2_62062;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
        });

        Thread autoUploadThread = new Thread(uploader::startAutoUpload);

        photoAdderThread.start();
        autoUploadThread.start();
    }
}
