package school.faang.task_48975;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload, "Загрузчик");

        Thread addPhotosThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(2000);
                    uploader.onNewPhotoAdded("photo" + i + ".jpg");
                }
            } catch (InterruptedException e) {
                System.out.println("Поток добавления фотографий прерван.");
                Thread.currentThread().interrupt();
            }
        }, "Добавляющий");

        uploadThread.start();
        addPhotosThread.start();

        try {
            uploadThread.join();
            addPhotosThread.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Работа программы завершена.");
    }
}
