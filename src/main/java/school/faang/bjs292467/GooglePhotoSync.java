package school.faang.bjs292467;

public class GooglePhotoSync {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        // Поток для загрузки фотографий
        Thread uploadThread = new Thread(uploader::startAutoUpload);

        // Поток для добавления новых фотографий
        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Задержка перед добавлением первой фотографии
                uploader.onNewPhotoAdded("photo1.jpg");

                Thread.sleep(2000); // Задержка перед добавлением второй фотографии
                uploader.onNewPhotoAdded("photo2.jpg");

                Thread.sleep(2000); // Задержка перед добавлением третьей фотографии
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Запускаем потоки
        uploadThread.start();
        photoAdderThread.start();
    }
}

