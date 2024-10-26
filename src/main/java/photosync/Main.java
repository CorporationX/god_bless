package photosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photoUploader = new GooglePhotosAutoUploader();

        Thread uploaderThead = new Thread(photoUploader::startAutoUpload);
        Thread addNewPhotosThread = new Thread(() -> {
            photoUploader.onNewPhotoAdded("photo1");
            photoUploader.onNewPhotoAdded("photo2");
            photoUploader.onNewPhotoAdded("photo3");
            photoUploader.onNewPhotoAdded("photo4");
        });

        uploaderThead.start();
        addNewPhotosThread.start();
    }
}
