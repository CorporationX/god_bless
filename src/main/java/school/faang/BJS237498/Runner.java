package school.faang.BJS237498;

public class Runner {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}
