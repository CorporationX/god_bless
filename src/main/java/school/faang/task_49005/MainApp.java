package school.faang.task_49005;

public class MainApp {
    public static void main(String[] args) {
        final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(uploader::startAutoUpload);

        Thread addPhotosThread = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                uploader.onNewPhotoAdded("Photo" + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        uploaderThread.start();
        addPhotosThread.start();
    }
}
