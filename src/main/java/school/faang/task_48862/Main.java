package school.faang.task_48862;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        final Thread thread1 = new Thread(uploader::startAutoUpload);
        final Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                uploader.onNewPhotoAdded("Photo " + (i + 1));
            }
        });

        thread1.start();
        thread2.start();
    }

}
