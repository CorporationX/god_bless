package faang.school.godbless.sprint.three.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>(List.of("path/photo_1", "path/photo_2", "path/photo_3"));

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            Thread.sleep(Constants.NEW_PHOTO_CHECK_INTERVAL);
            synchronized (this.photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    photosToUpload.wait();
                }
                this.uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        System.out.printf("Uploaded photo: %s%n", photosToUpload.remove(photosToUpload.size() - 1));
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (this.photosToUpload) {
            this.photosToUpload.add(photoPath);
            this.photosToUpload.notify();
        }
    }



}
