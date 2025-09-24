package school.faang.bjs2_92460;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        String photo = "foler1/1.png";
        String photo2 = "foler1/2.png";
        String photo3 = "foler1/3.png";
        List<String> photosToUpload = List.of(photo, photo2, photo3);

        Thread autoUpload = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });
        autoUpload.setDaemon(true);

        Thread addNewPhotos = new Thread(() -> {
            for (String photoPath : photosToUpload) {
                uploader.onNewPhotoAdded(photoPath);
            }
        });
        autoUpload.start();
        addNewPhotos.start();

        try {
            addNewPhotos.join();
            System.out.println("Ждем завершения загрузки на сервер");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Программа завершена");
    }
}
