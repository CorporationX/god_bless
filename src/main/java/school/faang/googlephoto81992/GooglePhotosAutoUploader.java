package school.faang.googlephoto81992;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    @Getter
    private List<String> photosToUpload = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(GooglePhotosAutoUploader.class);

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    System.out.println("фотографий готовых к загрузке нет");
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    public void uploadPhotos()  {
        for (String photo : photosToUpload) {
            logger.info("Фото с адресом {} загружено на сайт", photo);
        }
        photosToUpload.clear();
    }
}
