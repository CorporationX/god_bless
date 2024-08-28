package faang.school.godbless.BJS2_26018;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                googlePhoto.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread checkingThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    googlePhoto.onNewPhotoAdded("photo" + i + ".jpg");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        uploadThread.start();
        checkingThread.start();

        uploadThread.join();
        checkingThread.join();
    }
}
