package school.faang.BJS2_61638;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            System.out.println("Start uploading photos");
            googlePhotosAutoUploader.startAutoUpload();
        });

        Thread addNewPhotoThread = new Thread(() -> {
            GooglePhotosAutoUploader.sleep(1000);
            int i = 0;
            while (true) {
                googlePhotosAutoUploader.onNewPhotoAdded(
                        "Path for uploading photo %d".formatted(i++));
                GooglePhotosAutoUploader.sleep(1000);
            }
        });

        uploadThread.start();
        addNewPhotoThread.start();
    }
}
