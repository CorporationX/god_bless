package school.faang.task_48912;

public class MainLoader {

    public static void main(String[] args) {
        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        Thread loadPhoto = new Thread(() -> {
            while (true) {
                loader.startAutoUpload();
            }
        });

        Thread addPhoto = new Thread(() -> {
            loader.onNewPhotoAdded("photo1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            loader.onNewPhotoAdded("photo2");
            loader.onNewPhotoAdded("photo3");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        loadPhoto.setDaemon(true);
        loadPhoto.start();
        addPhoto.start();
    }
}