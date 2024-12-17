package school.faang.task_48862;

public class Main {
    private static final int PHOTOS_COUNT = 10;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        final Thread thread1 = new Thread(() -> uploader.startAutoUpload(PHOTOS_COUNT));
        final Thread thread2 = new Thread(() -> {
            for (int i = 0; i < PHOTOS_COUNT; i++) {
                uploader.onNewPhotoAdded(String.format("Photo %d.jpg", (i + 1)));
            }
        });

        thread1.start();
        thread2.start();
    }

}
