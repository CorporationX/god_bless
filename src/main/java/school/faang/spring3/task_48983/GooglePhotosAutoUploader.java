package school.faang.spring3.task_48983;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                    System.out.println("waiting");
                } catch (InterruptedException e) {
                    log.error("smth went wrong with wait " + e);
                    return;
                }
            }
            uploadPhotos();


        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
            System.out.println("notified");
        }
    }


    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("uploaded photo : " + item);
            iterator.remove();
        }
    }
}
