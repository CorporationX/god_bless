package faang.school.godbless.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        Thread uploadPhotos = new Thread(googlePhotos::startAutoUpload);

        Thread viewPhotos = new Thread(() -> {
            while (true) {
                googlePhotos.viewPhotos();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        uploadPhotos.start();
        viewPhotos.start();
    }
}
