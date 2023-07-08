package faang.school.godbless.GooglePhoto;

public class GooglePhoto {
    private String path;

    public GooglePhoto(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);

        Thread thread1 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path1"));
        Thread thread2 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path2"));
        Thread thread3 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path3"));
        Thread thread4 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path4"));
        Thread thread5 = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded("Path5"));

        Thread watchThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(googlePhotosAutoUploader.getUploadedPhotos());
        });

        uploadThread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        watchThread.start();
    }
}
