package faang.school.godbless.googlePhotos;

public class GooglePhotos {

    public static void main(String[] args) throws InterruptedException {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread lookPhotosThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("photo_" + i);
            }
        });

        uploadThread.start();
        lookPhotosThread.start();

        Thread.sleep(3000L);

        uploadThread.interrupt();

        System.out.println("EXIT");
    }
}
