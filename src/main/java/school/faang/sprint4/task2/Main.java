package school.faang.sprint4.task2;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        // Поток для загрузки фотографий
        Thread uploadThread = new Thread(uploader::startAutoUpload);

        // Поток для добавления новых фотографий
        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
        });

        // Запускаем потоки
        uploadThread.start();
        photoAdderThread.start();
    }
}
