package school.faang.sprint3.bjs249018;

public class PhotoSync {
    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();

        Thread autoUploader = new Thread(uploader::startAutoUpload);
        Thread photosAdder = new Thread(() -> {
            uploader.onNewPhotoAdded("C:/photos/003.jpg");
            uploader.onNewPhotoAdded("C:/photos/004.jpg");
            uploader.onNewPhotoAdded("C:/photos/005.jpg");
            uploader.startAutoUpload();
        });

        autoUploader.start();
        photosAdder.start();
    }
}