package school.faang.googlephotosync;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void startToUpload() throws InterruptedException {
        synchronized (lock){
            System.out.println("Start to upload...");
            while(photosToUpload.isEmpty()){
                System.out.println("Waiting for photos to upload");
                lock.wait();
            }

            uploadPhotos(photosToUpload.get(0));
        }
    }

    public void onNewPhotoAdded() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (lock) {
            System.out.println("Waiting for path input");
            String path = scanner.nextLine();
            photosToUpload.add(path);

            lock.notify();
            System.out.println("Notification was sent.");
        }
    }

    public void uploadPhotos(String path) {
        System.out.println("Photo uploaded.");
        photosToUpload.remove(path);
    }
}
