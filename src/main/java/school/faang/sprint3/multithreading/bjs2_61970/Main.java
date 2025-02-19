package school.faang.sprint3.multithreading.bjs2_61970;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                uploader.startAutoUpload();
            }
        });
        Thread photoAddedThread = new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                uploader.onNewPhotoAdded("Path" + i);
            }
        });
        uploaderThread.start();
        photoAddedThread.start();
    }
}
