package Google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            //Поток спит чтобы дать возможность photosToUpload заполниться
            //Иначе сразу вызывается wait, поток блокируется и никогда не завершается (если фотки больше не поступают)
            Thread.sleep(3000);
            if (photosToUpload.isEmpty()) {
                lock.wait();
            } else {
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Фото загружено на сервер");
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Фото добавлено в список загрузок");
            lock.notify();
        }

    }
}
