package school.faang.bjs2_73763;

/**
 * Задача "Google Photo sync"
 */
public class Main {

    public static void main(String[] args) {
        String[] photoPaths = new String[]{"фото1", "фото2", "фото3", "фото4", "фото5", "фото6", "фото7"};

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        new Thread(uploader::startAutoUpload).start();

        new Thread(() -> {
            for (String photoPath : photoPaths) {
                uploader.onNewPhotoAdded(photoPath);
            }
        }).start();
    }
}
