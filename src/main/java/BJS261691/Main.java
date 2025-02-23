package BJS261691;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread threadForAddPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("New Photo");
            uploader.onNewPhotoAdded("New Photo 2");
            uploader.onNewPhotoAdded("New Photo 3");
        });
        Thread threadForUpload = new Thread(() -> uploader.startAutoUpload());

        threadForAddPhoto.start();
        threadForUpload.start();
    }
}
