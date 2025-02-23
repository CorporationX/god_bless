package school.faang.task_61829;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();

        Thread addPhotoThread = new Thread(() -> {
            uploader.onNewPhotoAdded("Photo_1.png");
            uploader.onNewPhotoAdded("Photo_2.png");
            uploader.onNewPhotoAdded("Photo_3.png");
        });
        addPhotoThread.start();
    }
}
