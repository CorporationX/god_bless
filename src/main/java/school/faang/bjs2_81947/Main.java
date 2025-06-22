package school.faang.bjs2_81947;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadPhoto = new Thread(uploader::startAutoUpload);

        Thread addPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1");
            uploader.onNewPhotoAdded("photo2");
            uploader.onNewPhotoAdded("photo3");
        });

        uploadPhoto.start();
        addPhoto.start();
    }
}
