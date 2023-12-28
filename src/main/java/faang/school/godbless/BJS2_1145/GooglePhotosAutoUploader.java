package faang.school.godbless.BJS2_1145;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
@Getter
public class GooglePhotosAutoUploader {

    private Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();



    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath+ " added");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        if (!photosToUpload.isEmpty()) {
            for (String s : photosToUpload) {
                System.out.println(s+" uploaded to Google Photos");
            }
        }
        photosToUpload.clear();
    }

}
