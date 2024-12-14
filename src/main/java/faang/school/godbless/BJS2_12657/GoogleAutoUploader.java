package faang.school.godbless.BJS2_12657;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                try {
                    if (photosToUpload.isEmpty()) {
                        photosToUpload.wait();
                    }
                    uploadPhotos();
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
            }
        }
    }

    public void onNewPhotoAdded(String path) {
        synchronized (photosToUpload) {
            photosToUpload.add(path);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("uploading photos, please wait");
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Photos:" + photosToUpload + " have been uploaded");
            photosToUpload.clear();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void loadPhotosPool(List<String> photos) {
        photosToUpload.addAll(photos);
    }
}
