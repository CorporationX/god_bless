package faang.school.godbless.multi.task6photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Загрузка прервана");
            }
        });

        Thread addPhotosThread = new Thread(() -> {
            try {
                uploader.onNewPhotoAdded("photo1.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo2.jpg");
                Thread.sleep(2000);
                uploader.onNewPhotoAdded("photo3.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Загрузка прервана");
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        while (true) {
            if (!addPhotosThread.isAlive() && uploader.getPhotosToUpload().isEmpty()) {
                uploadThread.interrupt();
                break;
            }
        }
    }
}
