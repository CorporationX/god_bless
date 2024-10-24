package school.faang.google.photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadPhoto = new Thread(() -> uploader.startAutoUpload());
        Thread addPhoto = new Thread(() -> uploader.onNewPhotoAdded("Photo A", "Photo B", "Photo C"));

        uploadPhoto.start();
        addPhoto.start();
    }
}
