package school.faang.bjs2_90402;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader google = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            google.startToUpload();
        });
        Thread addPhotosThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                for (int i = 1; i <= 5; i++) {
                    String photoPath = "photo" + i + ".jpg";
                    google.onNewPhotoAdded(photoPath);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        uploadThread.start();
        addPhotosThread.start();

        uploadThread.join();
        addPhotosThread.join();
    }
}
