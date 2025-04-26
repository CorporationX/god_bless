package school.faang.sprint3multythreading.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            } else {
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload = IntStream.rangeClosed(1, 5)
                    .mapToObj(i -> String.format("%s%d", photoPath, i))
                    .collect(Collectors.toList());
            lock.notify();
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            photosToUpload.forEach(ph -> log.info("Фотография {} загружена на сервер.\n", ph));
            photosToUpload.clear();
            log.info("Список фотографий для загрузки очищен.");
        }
    }
}