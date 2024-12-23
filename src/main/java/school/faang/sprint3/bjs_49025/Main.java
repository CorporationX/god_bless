package school.faang.sprint3.bjs_49025;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();

        Thread autoUploadPhotosThread = new Thread(photosUploader::startAutoUpload);
        Thread addNewPhotos = new Thread(() -> {
            photosUploader.onNewPhotoAdded("my_pc/smile.jpg");
            photosUploader.onNewPhotoAdded("my_pc/lock.jpg");
            photosUploader.onNewPhotoAdded("my_pc/capture.jpg");
        });

        autoUploadPhotosThread.start();
        addNewPhotos.start();
    }
}
