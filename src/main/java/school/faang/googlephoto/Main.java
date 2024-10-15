package school.faang.googlephoto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread threadUploadPhoto = new Thread(() -> uploader.startAutoUpload());
        Thread threadAddPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("1.jpg");
            uploader.onNewPhotoAdded("2.jpg");
        });

        threadAddPhoto.start();
        threadUploadPhoto.start();
    }
}