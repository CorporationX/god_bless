package school.faang.sprint_3.task_49012;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread startPhoto = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread newPhoto = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("First Photo");
            googlePhotosAutoUploader.onNewPhotoAdded("Second Photo");
            googlePhotosAutoUploader.onNewPhotoAdded("Third Photo");
        });

        startPhoto.start();
        newPhoto.start();
    }
}
