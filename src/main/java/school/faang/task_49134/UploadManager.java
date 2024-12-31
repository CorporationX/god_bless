package school.faang.task_49134;

public class UploadManager {
    public static final String PHOTO_1 = "photo1.jpg";
    public static final String PHOTO_2 = "photo2.jpg";

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "UploadThread");
        Thread addPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded(PHOTO_1);
                Thread.sleep(500);
                uploader.onNewPhotoAdded(PHOTO_2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток добавления фотографий был прерван!");
            }
        }, "AddPhotoThread");

        uploadThread.start();
        addPhotoThread.start();

        try {
            uploadThread.join();
            addPhotoThread.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка выполнения потоков!");
            Thread.currentThread().interrupt();
        }
    }
}
