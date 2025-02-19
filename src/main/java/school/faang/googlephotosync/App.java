package school.faang.googlephotosync;

public class App {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(
                uploader::startAutoUpload,
                "AutoUploadThread"
        );

        Thread photoAdderThread = new Thread(() -> {
            int photoCounter = 1;
            while (photoCounter < 100) {
                uploader.onNewPhotoAdded("photo" + photoCounter + ".jpg");
                photoCounter++;
            }
        }, "PhotoAdderThread");

        autoUploadThread.start();
        photoAdderThread.start();
    }
}
