package BJS261691;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    log.info("Waiting photos to upload...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("Uploading {} photos...", photosToUpload.size());
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            log.info("New photo added: {}\n!Notify!", photoPath);
        }

    }

    public void uploadPhotos() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
                photosToUpload.forEach(path ->
                        System.out.println("Uploading " + path)
                );
                log.info("Uploading {} photos on server.", photosToUpload.size());
                //логика загрузки на сервер по типу:
                // если все фото отправлены на сервер,
                // то можно очистить список
                photosToUpload.clear();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
