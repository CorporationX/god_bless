package school.faang.bjs248934;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {

    }

    private void uploadPhotos() {
        photosToUpload.forEach(photo -> {

        });
        photosToUpload.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        //lock ->
    }

    public void addNewPhotos() {

    }
}
