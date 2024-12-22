package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
    }

    public synchronized void startAutoUpload() {
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            do {
                while (photosToUpload.isEmpty()) {
                    try {
                        log.info("Waiting for new photos to come");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            } while (System.currentTimeMillis() - startTime <= 10_000);
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        for(String photo: photosToUpload) {
            log.info("{} is uploaded to server", photo);
        }
        photosToUpload.clear();
    }
}

//            if (photosToUpload.isEmpty()) {
//                log.info("Waiting for new photos to come");
//                photosToUpload.wait();
//            } else {
//                uploadPhotos();
//            }

//try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

//public synchronized void addNewPhoto(){
//    try {
//        Thread.sleep(500);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//    onNewPhotoAdded("Photo_" + LocalDateTime.now()
//            .format(DateTimeFormatter.ofPattern("mm_ss.SSS")));
//    log.info("new photo added");
}
