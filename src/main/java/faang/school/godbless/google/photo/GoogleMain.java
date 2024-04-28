package faang.school.godbless.google.photo;

public class GoogleMain {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadPhotoThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread getPhotosThread = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path123"));
        uploadPhotoThread.start();
        getPhotosThread.start();
    }
}
