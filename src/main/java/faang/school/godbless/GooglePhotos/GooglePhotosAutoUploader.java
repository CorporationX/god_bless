package faang.school.godbless.GooglePhotos;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final ConcurrentLinkedQueue<Photo> photosToUpload = new ConcurrentLinkedQueue<>(List.of(
            new Photo("img1"),
            new Photo("img2"),
            new Photo("img3"),
            new Photo("img4"),
            new Photo("img5")
    ));

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error(e.getMessage());
                    }
                } else {
                    executorService.submit(this::uploadPhotos);
                }
            }
        }
    }

    private void uploadPhotos() {
        Photo photoToUpload = photosToUpload.poll();
        if (photoToUpload != null) {
            log.info("{} uploaded", photoToUpload.getName());
        }
    }

    public void onNewPhotoAdded(Photo photo) {
        photosToUpload.add(photo);
        log.info("Added new photo: {}", photo.getName());
        synchronized (photosToUpload) {
            photosToUpload.notifyAll();
        }
    }

}

