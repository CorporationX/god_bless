package school.faang.BJS2_61713;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader photosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(photosAutoUploader::startAutoUpload);
        Thread newPhotoThread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                photosAutoUploader.onNewPhotoAdded("photo" + i + ".png");
            }
        });
        uploadThread.start();
        newPhotoThread.start();
    }
}
