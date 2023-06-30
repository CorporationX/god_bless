package faang.school.godbless.GooglePhoto;

public class GooglePhoto {
    private String path;

    public GooglePhoto(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("Path1");
            googlePhotosAutoUploader.onNewPhotoAdded("Path2");
            googlePhotosAutoUploader.onNewPhotoAdded("Path3");
            googlePhotosAutoUploader.onNewPhotoAdded("Path4");
            googlePhotosAutoUploader.onNewPhotoAdded("Path5");
            googlePhotosAutoUploader.startAutoUpload();
        });
        Thread watchThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(googlePhotosAutoUploader.getUploadedPhotos());
        });

        uploadThread.start();
        watchThread.start();
    }
}
