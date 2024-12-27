package school.faang.task_49072;

public class Main {
    private static final int PHOTOS_COUNTER = 3;

    public static void main(String[] args) {

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);

        Thread photoAdderThread = new Thread(() -> {
            for (int i = 0; i < PHOTOS_COUNTER; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
            }
        });

        try {
            photoAdderThread.start();
            uploadThread.start();

            photoAdderThread.join();
            uploadThread.join();

            System.out.println("Все фотографии загружены!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток был прерван");
        }
    }
}
