package faang.school.godbless.synchronization.task_2.util;

import faang.school.godbless.synchronization.task_2.server.GooglePhoto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final GooglePhoto googlePhotoAccount;
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            while (photosToUpload.isEmpty()) {
                try {
                    photosToUpload.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
            uploadPhotos();
        }
     }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(googlePhotoAccount::addPhoto);
        photosToUpload.clear();
    }
}