package school.faang.bjs2_90590;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        log.info("Есть новое фото для загрузки");
        this.notify();
    }

    public synchronized void startAutoUpload() throws InterruptedException {
        boolean isFinish = false;
        LocalTime start = LocalTime.now();
        LocalTime end;
        while (true) {
            while (photosToUpload.isEmpty()) {
                end = LocalTime.now();
                if (end.getSecond() - start.getSecond() >= 15) {
                    isFinish = true;
                    break;
                }
                log.info("Ожидаю фото");
                this.wait(1000);
            }
            uploadPhotos();
            if (isFinish) {
                break;
            }
        }
    }

    private void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            log.info("Фото, расположенное по пути {}, загружено на сервер", photoPath);
        }
        photosToUpload.clear();
    }
}
