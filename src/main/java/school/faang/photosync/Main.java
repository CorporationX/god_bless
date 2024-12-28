package school.faang.photosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread threadAutoUpload = new Thread(uploader::startAutoUpload);
        threadAutoUpload.start();
        Thread threadAddPathPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1");
            uploader.onNewPhotoAdded("photo2");
        });
        threadAddPathPhoto.start();
    }
}