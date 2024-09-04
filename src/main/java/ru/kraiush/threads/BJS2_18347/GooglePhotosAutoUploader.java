package ru.kraiush.threads.BJS2_18347;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class GooglePhotosAutoUploader {

    private boolean lock = true;

    private List<GooglePhoto> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        for (int i = 0; i < 35; i++) {
            try {
                int num = ThreadLocalRandom.current().nextInt(1, 10);
                Thread.sleep(100 * num);
                if (num % 4 == 0) {
                    uploadPhotos(new GooglePhoto("photo-" + i));
//                    uploadPhotos(new GooglePhoto("photo-" + String.valueOf(i)), true);
                    seePhotos();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        seePhotos(false);
    }

    public synchronized void uploadPhotos(GooglePhoto photo) {
//        public synchronized void uploadPhotos(GooglePhoto photo, boolean lock) {

//        System.out.println("uploadPhotos - lock: " + lock);
        while (!lock) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread Interrupted - " + Thread.currentThread().getName());
            }
        }
        GooglePhoto photoWithPath = onNewPhotoAdded(photo);
        photosToUpload.add(photoWithPath);
        System.out.println("\nnew photo uploaded: " + photoWithPath);
        lock = false;
        notifyAll();
    }

    public synchronized List<GooglePhoto> seePhotos() {
        while (lock) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread Interrupted - " + Thread.currentThread().getName());
            }
        }
        System.out.println("\nall loaded photos from Google");
        photosToUpload.forEach(System.out::println);
        notifyAll();
        lock = true;
        return photosToUpload;
    }

    private synchronized GooglePhoto onNewPhotoAdded(GooglePhoto photo) {
        photo.setPhotoPath("https://google.com/photos/" + ThreadLocalRandom.current().nextInt(1, 1000));
        notifyAll();
        return photo;
    }
}
