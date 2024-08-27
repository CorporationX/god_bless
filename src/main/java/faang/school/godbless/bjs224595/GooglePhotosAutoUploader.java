package faang.school.godbless.bjs224595;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photos = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photos.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        synchronized (lock) {
            var iterator = this.photos.iterator();
            while (iterator.hasNext()) {
                var photo = iterator.next();
                try {
                    Thread.sleep(250);
                    System.out.println("Photo has been uploaded: " + photo);
                    iterator.remove();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void addNewPhoto(String photo) {
        synchronized (lock) {
            this.photos.add(photo);
            try {
                Thread.sleep(250);
                System.out.println(photo + " has been added");
                lock.notify();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}