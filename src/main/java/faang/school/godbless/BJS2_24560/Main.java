package faang.school.godbless.BJS2_24560;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");

        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo3.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo4.jpg");
                Thread.sleep(3000);
                uploader.onNewPhotoAdded("photo5.jpg");
                uploader.stopAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Процесс добавления фотографий был прерван.");
            }
        }, "AddPhotoThread");

        uploadThread.start();
        addPhotoThread.start();
    }
}
