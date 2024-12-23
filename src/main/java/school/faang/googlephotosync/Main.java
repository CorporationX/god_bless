package school.faang.googlephotosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploadPhotoThread = new Thread(autoUploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> {
            autoUploader.onNewPhotoAdded("photo1.jpg");
            autoUploader.onNewPhotoAdded("photo2.jpg");
        });

        uploadPhotoThread.start();
        addPhotoThread.start();
    }
}
