package faang.school.godbless;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Slf4j
public class GooglePhotosAutoUploader {
    private  List<String> photosToUpload = new ArrayList<>();
    private final Object lock;

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    log.info("waiting before fotos come"  );
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i<photosToUpload.size();i++){
                if (photosToUpload.size() < i){
                    break;
                }
                var photo = photosToUpload.get(i);
                try {
                    log.info("staered uploading to server " + photo );
                    Thread.sleep(2000);
                    log.info(" uploaded to server " + photo );
                    photosToUpload.remove(photo);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            log.info("onNewPhotoAdded " + photoPath);
            photosToUpload.add(photoPath);

        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            lock.notify();
        }
    }
}
