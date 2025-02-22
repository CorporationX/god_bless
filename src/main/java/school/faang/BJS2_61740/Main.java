package school.faang.BJS2_61740;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadPhotos = new Thread(uploader::startAutoUpload);
        Thread addNewPhotos = new Thread(() -> uploader.onNewPhotoAdded("library/photos/photo.jpg"));

        autoUploadPhotos.start();
        addNewPhotos.start();
    }
}
