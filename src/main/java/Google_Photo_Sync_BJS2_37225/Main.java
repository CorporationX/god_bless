package Google_Photo_Sync_BJS2_37225;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(() -> uploader.startAutoUpload());
        Thread photoAddThread = new Thread(() -> {
            uploader.onNewPhotoAdded("picture1.jpg");
            uploader.onNewPhotoAdded("picture.jpg");
        });

        autoUploadThread.start();
        photoAddThread.start();
    }
}