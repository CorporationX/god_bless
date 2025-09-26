package school.faang.bjs2_92460;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        String photo = "foler1/1.png";
        String photo2 = "foler1/2.png";
        String photo3 = "foler1/3.png";
        List<String> photosToUpload = List.of(photo, photo2, photo3);

        Thread autoUpload = new Thread(() -> {
            while (flag.get()) {
                uploader.startAutoUpload();
            }
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread addNewPhotos = new Thread(() -> photosToUpload.forEach(uploader::onNewPhotoAdded));
        autoUpload.start();
        addNewPhotos.start();

        try {
            addNewPhotos.join();
            System.out.println("Ждем завершения загрузки на сервер");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        flag.set(false);
        autoUpload.interrupt();
        System.out.println("Выключаем автозагрузку");
        System.out.println("Программа завершена");
    }
}
