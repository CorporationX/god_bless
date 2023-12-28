package googlePhoto_1096;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private static final Object lock = new Object();
    private static List<String> photosToUpload = new ArrayList<>();
    private static List<GooglePhoto> photos = new ArrayList<>();

    public static void main(String[] args) {
        photos = List.of(new GooglePhoto("C:\\Users\\Public\\Pictures_1"),
                new GooglePhoto("C:\\Users\\Public\\Pictures_2"),
                new GooglePhoto("C:\\Users\\Public\\Pictures_3"));

        Thread startLoad = new Thread(() -> {
            try {
                startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток загрузки завершен");
            }
        }, "Run UpLoad");

        Thread addPhoto = new Thread(() -> {
            for (GooglePhoto googlePhoto : photos) {
                onNewPhotoAdded(googlePhoto.getPhotoPath());
            }
        }, "Add NewPhoto");

        startLoad.start();
        addPhoto.start();

        // Завершение процесса бесконечного цикла в startAutoUpload().
        // Проверяем закончен ли поток addPhoto и закончил ли работу по добавлению и очистке photosToUpload поток startLoad
        while (true) {
            if (!addPhoto.isAlive() && photosToUpload.isEmpty()) {
                startLoad.interrupt();
                break;
            }
        }
    }

    public static void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public static void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Выполняется загрузка фотографии из директории - " + photo);
            System.out.println("Загрузка выполнена");
        }
        photosToUpload.clear();
    }

    public static void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фотография добавлена " + photoPath);
            lock.notify();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
        }
    }
}