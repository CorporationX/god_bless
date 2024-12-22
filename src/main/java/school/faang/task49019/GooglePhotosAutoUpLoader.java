package school.faang.task49019;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GooglePhotosAutoUpLoader {
    private final Object lock = new Object();

    private final List<String> photosToUpLoad;


    public void startAutoUpLoad() {
        synchronized (lock) {
            while (photosToUpLoad.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info(" Поток был прерван ");
                }
            }
            upLoadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpLoad.add(photoPath);
            lock.notify();
        }
    }

    public void upLoadPhotos() {
        for (String photo : photosToUpLoad) {
            log.info("Загружаем фотографию {} ", photo);
        }
        photosToUpLoad.clear();
    }
}
