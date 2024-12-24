package school.faang.sprint3.task_bjs249004;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("E:\\Foto\\photo1.jpg");
            uploader.onNewPhotoAdded("E:\\Foto\\photo2.jpg");
            uploader.onNewPhotoAdded("E:\\Foto\\photo3.jpg");
            uploader.onNewPhotoAdded("E:\\Foto\\photo4.jpg");
            uploader.onNewPhotoAdded("E:\\Foto\\photo5.jpg");
        });

        uploadThread.start();
        photoAdderThread.start();
    }
}
