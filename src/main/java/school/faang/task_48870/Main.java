package school.faang.task_48870;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploader = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread newPhotos = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("/C/newPath/siqence");
            googlePhotosAutoUploader.onNewPhotoAdded("/C/newPath/silence");
            googlePhotosAutoUploader.onNewPhotoAdded("/C/newPath/horor");
            googlePhotosAutoUploader.onNewPhotoAdded("/C/newPath/News");
        });

        autoUploader.start();
        newPhotos.start();
    }
}
