package faang.school.godbless.BJS2_12657;

import java.util.ArrayList;
import java.util.Arrays;
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
                    photosToUpload.clear();
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

    public void uploadPhotos() {
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

    public static void main(String[] args) {
        List<String> photos = Arrays.asList("MyPhoto", "LandscapePhoto", "Mom's portrait", "Wedding photo", "Birth Day");
        List<String> newPhotos = Arrays.asList("My Best Friend", "Driving", "First step", "Happiest moment", "Pool day");
        GoogleAutoUploader googlePhoto = new GoogleAutoUploader();
        Thread loadThread = new Thread(() -> googlePhoto.loadPhotosPool(photos));
        Thread firstThread = new Thread(googlePhoto::startAutoUpload);
        Thread secondThread = new Thread(() -> newPhotos.forEach(googlePhoto::onNewPhotoAdded));
        loadThread.start();
        firstThread.start();
        secondThread.start();
    }
}
