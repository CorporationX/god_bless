package school.faang.naughtwoBJS261877;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(autoUploader::startAutoUpload);
        uploadThread.start();
        Thread photoAdderThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("photo1.jpg");
            autoUploader.onNewPhotoAdded("photo2.jpg");
        });
        photoAdderThread.start();
    }
}
