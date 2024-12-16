package school.faang.task48853;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUpload = new Thread(uploader::startAutoUpload);

        autoUpload.start();

        Thread addNewPhoto = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1");
            uploader.onNewPhotoAdded("photo2");
        });

        addNewPhoto.start();
    }
}
