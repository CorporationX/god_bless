package school.faang.bjs2_73900;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GooglePhotosAutoUploader {
    private List<String> paths = new ArrayList<>();

    public void onNewPhotoAdded(String photoPath) {
        synchronized(paths) {
            paths.add(photoPath);
            paths.notify();
        }
    }

    public void uploadPhotos() {
        synchronized(paths) {
            if (paths.isEmpty()) {
                try {
                    paths.wait();
                } catch (InterruptedException e) {
                    log.error("Process was interrupted. {}.", e.getMessage());
                }
            }
            paths.stream()
                .findFirst()
                .ifPresent(path -> {
                    log.info("Photo has been uploaded to {}.", path);
                    paths.remove(path);
                });
        }
    }
}
