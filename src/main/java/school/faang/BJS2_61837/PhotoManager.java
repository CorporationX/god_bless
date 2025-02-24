package school.faang.BJS2_61837;

public class PhotoManager {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
            uploader.onNewPhotoAdded("photo4.jpg");
            uploader.onNewPhotoAdded("photo5.jpg");
        });
        Thread uploadThread = new Thread(uploader::startAutoUpload);

        photoAdderThread.start();
        uploadThread.start();
    }
}
