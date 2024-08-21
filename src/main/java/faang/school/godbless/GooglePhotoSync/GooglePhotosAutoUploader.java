package faang.school.godbless.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private List<String> uploadedPhotos = new ArrayList<>();

    private synchronized void addPhotoToUpload(String photo) {
        photosToUpload.add(photo);
    }

    public synchronized void watchUploadedPhotos() {
        uploadedPhotos.forEach(System.out::println);
    }

    public synchronized void startAutoUpload() {
        while (true) {
            if (photosToUpload.isEmpty()) {
                System.out.println("фоточек нема");
                try {
                    wait();
                    System.out.println("ооо фоточки поступили");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhoto(photosToUpload.remove(0));
        }
    }

    private synchronized void uploadPhoto(String photoToUpload) {
        System.out.println("выложил крутямбовую фоточку: " + photoToUpload);
        uploadedPhotos.add(photoToUpload);
    }

    public synchronized void onNewPhotoAdded(String photoToUpload) {
        addPhotoToUpload(photoToUpload);
        notify();
    }
}
