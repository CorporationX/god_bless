package faang.school.godbless.gphoto;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
@Getter
public class GooglePhotosAutoUploader {
    private final Queue<String> photosToUpload = new ArrayDeque<>();
    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotos();
        }
    }
    public void uploadPhotos() throws InterruptedException {
        System.out.println("Load started");
        Thread.sleep(500);
        photosToUpload.forEach(System.out::println);
        System.out.println("Load ended");
        photosToUpload.clear();
    }
    public void onNewPhotoAdded(String path) {
        synchronized (photosToUpload) {
            photosToUpload.add(path);
            photosToUpload.notify();
        }
    }
}
