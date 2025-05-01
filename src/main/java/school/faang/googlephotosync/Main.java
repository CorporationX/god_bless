package school.faang.googlephotosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadPhotoTread = new Thread(uploader::startAutoUpload);

        Thread addPhotoTread = new Thread(() -> {
            uploader.onNewPhotoAdded("Car");
            uploader.onNewPhotoAdded("Car");
            uploader.onNewPhotoAdded("Apple");
        });

        uploadPhotoTread.start();
        addPhotoTread.start();
    }
}
