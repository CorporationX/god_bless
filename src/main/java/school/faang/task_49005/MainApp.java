package school.faang.task_49005;

public class MainApp {
    private static final int ADD_PHOTOS_DELAY_MS = 2000;

    public static void main(String[] args) {
        final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(uploader::startAutoUpload);

        Thread addPhotosThread = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                uploader.onNewPhotoAdded("Photo" + i + 1);
                try {
                    Thread.sleep(ADD_PHOTOS_DELAY_MS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploaderThread.start();
        addPhotosThread.start();
        try {
            addPhotosThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        uploader.stopUploader();
        try {
            uploaderThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Application finished.");
    }
}
