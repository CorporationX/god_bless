package school.faang.task_49043;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(autoUploader::startAutoUpload);
        Thread photoUploader = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                autoUploader.onNewPhotoAdded("photo" + i + ".jpg");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        uploadThread.start();
        photoUploader.start();

        uploadThread.join();
        photoUploader.join();
    }
}
