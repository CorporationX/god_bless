package mod1sp3.googlePhotoSync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploadPhotoThread = new Thread(() -> {
            googlePhotosAutoUploader.startAutoUpload();
        });
        Thread addNewPhotoThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("home/photos/anapa2007");
        });

        autoUploadPhotoThread.start();
        addNewPhotoThread.start();
    }
}
