package school.faang.sprint3.googlephotosync;

public class Main {


    public static void main(String[] args) {
        GooglePhotosAutoUpdater googlePhotosAutoUpdater = new GooglePhotosAutoUpdater();
        Thread uploadThread = new Thread(() -> googlePhotosAutoUpdater.startAutoUpload());

        Thread photoAddThread = new Thread(() -> {
            googlePhotosAutoUpdater.onNewPhotoAdded("image1.png");
            googlePhotosAutoUpdater.onNewPhotoAdded("image2.png");
        });

        uploadThread.start();
        photoAddThread.start();
    }
}
