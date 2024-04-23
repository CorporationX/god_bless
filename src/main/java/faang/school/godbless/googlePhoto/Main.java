package faang.school.godbless.googlePhoto;

public class Main {
    public static void main(String[] args) {
        String photoPath = "new photo";
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread autoUpload = new Thread(googlePhoto::startAutoUpload);
        Thread addPhoto = new Thread(() -> googlePhoto.onNewPhotoAdded(photoPath));

        autoUpload.start();
        addPhoto.start();

    }
}
