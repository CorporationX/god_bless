package faang.school.godbless.GooglePhotoSync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        Thread uploadPhotos = new Thread(() -> {
            try {
                googlePhotos.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Загрузка завершена");
            }
        });
        Thread viewingPhotos = new Thread(() -> {
            try {
                googlePhotos.onNewPhotoAdded("path10");
                Thread.sleep(5000);
                googlePhotos.onNewPhotoAdded("path11");
                Thread.sleep(3000);
                googlePhotos.onNewPhotoAdded("path12");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ошибка...");
            }
        });

        uploadPhotos.start();
        viewingPhotos.start();

        while (true) {
            if (!viewingPhotos.isAlive() && googlePhotos.getPhotosToUpload().isEmpty()) {
                uploadPhotos.interrupt();
                break;
            }
        }
    }
}
