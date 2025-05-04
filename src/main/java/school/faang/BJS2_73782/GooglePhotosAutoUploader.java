package school.faang.BJS2_73782;

import java.util.concurrent.CopyOnWriteArrayList;

public class GooglePhotosAutoUploader {
    private final CopyOnWriteArrayList<String> photosToUpload;
    private final Object lock = new Object();

    public GooglePhotosAutoUploader() {
        this.photosToUpload = new CopyOnWriteArrayList<>();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println("Uploading photo: " + photoPath);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Uploaded photo: " + photoPath);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New photo added: " + photoPath);
            lock.notify();
        }
    }


}
