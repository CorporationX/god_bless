package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("Path to the first photo");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {

        });
        thread1.start();
        thread2.start();
    }
}
