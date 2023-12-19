package faang.school.godbless.multi.task6photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });

        Thread addPhotosThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
        });

        uploadThread.start();
        addPhotosThread.start();
    }
}
