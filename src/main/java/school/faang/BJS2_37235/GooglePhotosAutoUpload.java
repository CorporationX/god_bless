package school.faang.BJS2_37235;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class GooglePhotosAutoUpload {
    private final Logger logger = Logger.getLogger(GooglePhotosAutoUpload.class.getName());
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.log(Level.WARNING, "Поток был прерван во время ожидания", e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String str) {
        synchronized (lock) {
            photosToUpload.add(str);
            lock.notify();
        }
    }

    public void uploadPhotos() {
        for (String str : photosToUpload) {
            System.out.println("Фото: " + str + " загружается");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Загрузка фото была прервана", e);
            }
            System.out.println("Фото загружено");
        }
        photosToUpload.clear();
    }
}
