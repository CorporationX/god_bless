package faang.school.godbless.thirdsprint.googlephotosync;

public class Main {
    private static final int TEST_NUM_PHOTOS = 10;
    private static final int WAIT_TIME = 300;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            for (int i = 1; i <= TEST_NUM_PHOTOS; i++) {
                try {
                    Thread.sleep(WAIT_TIME);
                    uploader.onNewPhotoAdded("/home/photos/photo" + i + ".jpg");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        try {
            addPhotosThread.join();
            uploadThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
