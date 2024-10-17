package school.faangSprint3.t06;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread photoAdderThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    uploader.onNewPhotoAdded("photo" + i + ".jpg");
                    Thread.sleep(2000);
                }
                Thread.sleep(2000);
                uploader.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}