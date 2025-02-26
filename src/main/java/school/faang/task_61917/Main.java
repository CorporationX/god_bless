package school.faang.task_61917;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(() -> {
            while (true) {
                googlePhotosAutoUploader.startAutoUpload();
            }
        });
        Thread newPhotoThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded(String.format("Photo %d.png", i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Восстанавливаем статус прерывания
                    System.out.println("Поток добавления фотографий прерван " + e);
                    return;
                }
            }
        });
        autoUploadThread.start();
        newPhotoThread.start();
    }
}
