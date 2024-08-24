package faang.school.godbless.BJS2_24356;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
       synchronized (lock){
           try {
               while (true){
                   if (photosToUpload.isEmpty()) {
                       log.info("No photos, waiting");
                       lock.wait();
                   }
                   log.info("thread is alive!");
                   uploadPhotos();
               }
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               log.error("auto loader got an error: {}", e.getMessage());
           }
       }
    }

    public void uploadPhotos(){
        synchronized (lock){
            log.info("Loading in Google cloud");
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath){
       synchronized (lock){
          log.info("adding {} to list%n", photoPath);
           photosToUpload.add(photoPath);
           lock.notify();
       }
    }
}
