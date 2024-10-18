package school.faang.google.photo;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadingPhoto = new Thread(uploader::startAutoUpload);
        Thread addingPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("Path1");
            uploader.onNewPhotoAdded("Path2");
            uploader.onNewPhotoAdded("Path3");
            uploader.onNewPhotoAdded("Path4");
            uploader.onNewPhotoAdded("Path5");
        });
        addingPhoto.start();
        uploadingPhoto.start();
    }
}
