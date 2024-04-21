package faang.school.godbless.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        photosToUpload = initialize();
    }

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                }
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        photosToUpload.forEach(s -> System.out.println("Photo " + s + " has been upload"));
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }

    }

    private List<String> initialize() {
        List<String> photos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            photos.add("users/username/documents/" + (i + 1) + ".png");
        }
        return photos;
    }
}
