package school.faang.bjs2_73763;

/**
 * Задача "Google Photo sync"
 */
public class Main {

    public static void main(String[] args) {
        String[] photoPaths = new String[]{"фото1", "фото2", "фото3", "фото4", "фото5", "фото6", "фото7"};

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(uploader::startAutoUpload);

        Thread addNewPhotosThread = new Thread(() -> {
            for (String photoPath : photoPaths) {
                uploader.onNewPhotoAdded(photoPath);
            }
        });

        autoUploadThread.start();
        addNewPhotosThread.start();

        try {
            addNewPhotosThread.join();
        } catch (InterruptedException e) {
            System.out.printf("Thread '%s' interrupted%n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }

        uploader.stopAutoUpload();
    }
}
