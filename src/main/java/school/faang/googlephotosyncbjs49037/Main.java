package school.faang.googlephotosyncbjs49037;

public class Main {
    private static final int ADD_PHOTO_DELAY_MS = 2000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread addPhotosThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 5; i++) {
                    Thread.sleep(ADD_PHOTO_DELAY_MS);
                    uploader.onNewPhotoAdded("photo: " + i + ".jpg");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        addPhotosThread.start();
    }
}
