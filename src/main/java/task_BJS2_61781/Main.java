package task_BJS2_61781;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadPhotos = new Thread(uploader::startAutoUpload);
        Thread addPhotos = new Thread(() -> {
            uploader.onNewPhotoAdded("java.jpg");
            uploader.onNewPhotoAdded("swift.jpeg");
        });

        autoUploadPhotos.start();
        addPhotos.start();
    }
}
