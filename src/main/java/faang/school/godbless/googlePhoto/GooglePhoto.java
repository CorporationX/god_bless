package faang.school.godbless.googlePhoto;

public class GooglePhoto {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        String url = "path of some foto";

        Thread newPhotoThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(url));
        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        newPhotoThread.start();
        uploadThread.start();
    }
}
