package school.faang.sprint_1.task_googlephotosyncbjs2n48944;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload;
    private long startTime;

    public GooglePhotosAutoUploader(@NonNull List<String> photosToUpload) {
        this.photosToUpload = photosToUpload;
        startTime = System.currentTimeMillis();
    }
    public synchronized void startAutoUpload() {
        synchronized (lock) {
            do {
                if (photosToUpload.isEmpty()) {
                    try {
                        log.info("Waiting for new photos to come");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    uploadPhotos();
                }
            } while (System.currentTimeMillis() - startTime < 10_000);
        }
    }
    public synchronized void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("adding new photo ....");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
    private void uploadPhotos() {
        for (String photo : photosToUpload) {log.info("{} is uploaded to server", photo);}
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

//   try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

